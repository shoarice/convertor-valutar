package actori;

import java.util.HashMap;
import java.util.Map;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.MarshallerStiri;

public class PublicatorActiuniStiri {
	private Context ctx;
	private Connection conn;
	private Session session;
	private MarshallerStiri marshaller;
	
	private Map<Integer, MessageProducer> cache;
	
	public PublicatorActiuniStiri(){
		try {
			
			ctx = new InitialContext();
			ConnectionFactory cf2 = (ConnectionFactory) ctx.lookup("queueConnectionFactory");
			Connection conn = cf2.createConnection();
			conn.start();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			this.conn = conn;
			this.session = session;
			marshaller = new MarshallerStiri(session);
			cache = new HashMap<Integer, MessageProducer>();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void trimiteStireDeschisa(int stireId,int autorId){
		trimiteEveniment(stireId,autorId,"deschis");
	}
	
	public void trimiteStireInchisa(int stireId,int autorId){
		trimiteEveniment(stireId,autorId, "inchis");
	}

	private void trimiteEveniment(int stireId,int autorId,String tipEveniment) {
		try {
			MessageProducer producer = cache.get(autorId);
			if(producer == null){
				Destination dest = (Destination) ctx.lookup("dynamicQueues/"+autorId);
				producer = session.createProducer(dest);
				producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
				
				cache.put(autorId, producer);
			}
			
			TextMessage msg = session.createTextMessage();
			msg.setStringProperty("tip", tipEveniment);
			msg.setIntProperty("stireId", stireId);
			
			producer.send(msg);
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
}
