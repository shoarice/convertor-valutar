package actori;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.UnmarshallerStiri;

public class ReceptorStiri {
	
	private Context ctx;
	private Connection conn;
	private Session session;
	private UnmarshallerStiri unmarshaller;
	
	private Map<String, MessageConsumer> consumers;
	public ReceptorStiri() {
		try {
			ctx = new InitialContext();
			ConnectionFactory cf2 = (ConnectionFactory) ctx.lookup("topicConnectionFactory");
			Connection conn = cf2.createConnection();
			conn.start();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			this.conn = conn;
			this.session = session;
			unmarshaller = new UnmarshallerStiri();	
			consumers = new HashMap<String, MessageConsumer>();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void inregistreazaAscultatorStiri(String topic, final AscultatorStiri asc) {
		inregistreazaAscultatorDeMesaje(topic, null, asc);
	}
	
	public void inregistreazaAscultatorDeMesaje(String topic, String filter, final AscultatorStiri asc) {
		try {
			MessageConsumer mc = consumers.get(topic);
			
			if(mc != null){
				consumers.remove(topic);
				mc.close();
			}
			
			Destination topicDest = (Destination) ctx.lookup("dynamicTopics/"+topic);
			mc = session.createConsumer(topicDest);
		
			if(filter != null)
				mc = session.createConsumer(topicDest,filter);
			else
				mc = session.createConsumer(topicDest);
			
			mc.setMessageListener(new MessageListener() {
				
				@Override
				public void onMessage(Message arg0) {
					try {
						asc.laStire(unmarshaller.unmarshall((TextMessage) arg0), arg0.getStringProperty("tip"));
					} catch (JMSException e) {
						e.printStackTrace();
					}
				}
			});
		} catch (JMSException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	public void nuMaiRecepta(){
		consumers.clear();
	}
}
