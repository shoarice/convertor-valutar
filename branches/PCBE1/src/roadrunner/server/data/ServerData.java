package roadrunner.server.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

import roadrunner.server.logger.Logger;

public class ServerData extends Thread{
	private static ServerData instance = new ServerData();
	public static ServerData instance(){
		return instance;
	}
	
	
	private List<String> namesTaken; //numele de clienti ocupate
	private Map<Integer, String> clients; //asta va contine informatiile despre client (nume, queue etc). momentan doar numele
	
	private Map<String,List<Message>> topics;
	private Map<String, ConcurrentLinkedQueue<Mail>> queues;
	private boolean run = true;
	private int globalExpireTime;
	
	private ServerData(){
		namesTaken = Collections.synchronizedList(new ArrayList<String>());
		clients = Collections.synchronizedMap(new HashMap<Integer, String>());
		
		topics = Collections.synchronizedMap(new HashMap<String, List<Message>>());
		queues = Collections.synchronizedMap(new HashMap<String, ConcurrentLinkedQueue<Mail>>());
	}
	
	public void addClient(int id, String name){
		clients.put(id, name);
		queues.put(name, new ConcurrentLinkedQueue<Mail>());
		addNameTaken(name);
	}
	
	public String getClient(int id){
		return clients.get(id);
	}
	
	public void removeClient(int id){
		String name = clients.remove(id);
		queues.remove(name);
		
		if(name != null)
			removeNameTaken(name);
	}
	
	private void addNameTaken(String name){
		namesTaken.add(name);
		synchronized (namesTaken) {
			Collections.sort(namesTaken);
		}
	}
	
	public boolean isNameTaken(String name){
		synchronized (namesTaken) {
			if(Collections.binarySearch(namesTaken, name) < 0)
				return false;
			
			return true;			
		}
	}
	
	private void removeNameTaken(String name){
		int i=0;
		synchronized (namesTaken) {
			if((i=Collections.binarySearch(namesTaken, name)) < 0)
				return;
			
			namesTaken.remove(i);			
		}
	}

	public void publishTopicMessage(String topicDestination, String msg, int expireTime) {
		/**
		 * Daca publicarea mesajului nu e atomica exista posibilitatea ca
		 * sa se adauge un topic cu o lista goala, threadul curent se opreste
		 * vine thread-ul care se ocupa de mesajele expirate, vede un topic cu lista goala
		 * il sterge, apoi threadul care vrea sa publice mesajul, nu mai are unde 
		 * sa il publice
		 */
		synchronized (topics) {
			if(!topics.containsKey(topicDestination)){
				List<Message> list = Collections.synchronizedList(new ArrayList<Message>());
				topics.put(topicDestination, list);
			}
			
			topics.get(topicDestination).add(new Message(msg, expireTime));			
		}
	}
	
	public boolean deliverMailMessage(String owner, String msg, int senderId) {
		String sender = clients.get(senderId);
		Mail mail = new Mail(sender, msg);
		ConcurrentLinkedQueue<Mail> queue = queues.get(owner);
		if (queue != null) {
			queue.offer(mail);
			return true;
		} else {
			return false;
		}
	}

	public boolean topicExists(String topic) {
		return topics.containsKey(topic);
	}

	public List<String> getTopicMessages(String topic) {
		List<Message> src = topics.get(topic);
		List<String> msgs = new ArrayList<String>(src.size());
		
		synchronized (src) {
			for(Message msgMessage: src) 
				msgs.add(new String(msgMessage.getMsg()));		
		}

		return msgs;
	}

	@Override
	public void run() {
		while(run){
			synchronized (topics) {
				for (String topicName : topics.keySet()) {
					List<Message> msgs = topics.get(topicName);
					
					synchronized (msgs) {
						Iterator<Message> it = msgs.iterator();
						while(it.hasNext()){
							Message msg = it.next();
							
							if(msg.isExpired(globalExpireTime)){
								it.remove();
								Logger.log("Message expired", msg, -1);
							}
						}
						
						if(msgs.size() == 0)
							topics.remove(topicName);
					}
				}
			}
		}
	}

	public void setRun(boolean run) {
		this.run = run;
	}

	public void setGlobalTopicExpireTime(int globalExpireTime) {
		this.globalExpireTime = globalExpireTime;
	}
}
