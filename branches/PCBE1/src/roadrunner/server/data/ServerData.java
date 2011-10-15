package roadrunner.server.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServerData {
	private static ServerData instance = new ServerData();
	public static ServerData instance(){
		return instance;
	}
	
	
	private List<String> namesTaken; //numele de clienti ocupate
	private Map<Integer, String> clients; //asta va contine informatiile despre client (nume, queue etc). momentan doar numele
	
	private Map<String,List<String>> topics;
	
	private ServerData(){
		namesTaken = Collections.synchronizedList(new ArrayList<String>());
		clients = Collections.synchronizedMap(new HashMap<Integer, String>());
		
		topics = Collections.synchronizedMap(new HashMap<String, List<String>>());
	}
	
	public void addClient(int id, String name){
		clients.put(id, name);
		addNameTaken(name);
	}
	
	public String getClient(int id){
		return clients.get(id);
	}
	
	public void removeClient(int id){
		String name = clients.remove(id);
		
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

	public void publishTopicMessage(String topicDestination, String msg) {
		if(!topics.containsKey(topicDestination)){
			List<String> list = Collections.synchronizedList(new ArrayList<String>());
			topics.put(topicDestination, list);
		}
		
		topics.get(topicDestination).add(msg);
	}
}
