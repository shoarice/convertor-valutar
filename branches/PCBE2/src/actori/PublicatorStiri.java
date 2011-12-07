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
import model.Stire;

public class PublicatorStiri {
	private Context ctx;
	private Connection conn;
	private Session session;
	private MarshallerStiri marshaller;
	
	private Map<String, MessageProducer> cache;
	
	public PublicatorStiri(){
		try {
			
			ctx = new InitialContext();
			ConnectionFactory cf2 = (ConnectionFactory) ctx.lookup("topicConnectionFactory");
			Connection conn = cf2.createConnection();
			conn.start();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			this.conn = conn;
			this.session = session;
			marshaller = new MarshallerStiri(session);
			cache = new HashMap<String, MessageProducer>();
			
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void publicareStire(Stire stire, String topic) throws JMSException, NamingException{
		trimiteEveniment(stire, topic, "publicare");
	}

	public void modificareStire(Stire stire, String topic) throws JMSException, NamingException{
		trimiteEveniment(stire, topic, "modificare");
	}
	
	public void stergereStire(Stire stire, String topic) throws JMSException, NamingException{
		trimiteEveniment(stire, topic, "stergere");
	}

	private void trimiteEveniment(Stire stire, String topic, String tipEveniment) throws JMSException, NamingException {
		TextMessage msg = marshaller.marshall(stire);
		msg.setStringProperty("tip", tipEveniment);
		
		MessageProducer producer = cache.get(topic);
		if(producer == null){
			Destination topicDest = (Destination) ctx.lookup("dynamicTopics/"+topic.toLowerCase());
			producer = session.createProducer(topicDest);
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			
			cache.put(topic, producer);
		}
		
		producer.send(msg);
	}

	public void inchideConn(){
		try {
			conn.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
