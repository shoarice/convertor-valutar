package actori;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.UnmarshallerStiri;

public class ReceptorActiuniStiri {
	private Context ctx;
	private Connection conn;
	private Session session;
	private UnmarshallerStiri unmarshaller;
	
	private MessageConsumer consumer;
	private int autorId;
	public ReceptorActiuniStiri(int autorId) {
		try {
			ctx = new InitialContext();
			ConnectionFactory cf2 = (ConnectionFactory) ctx.lookup("queueConnectionFactory");
			Connection conn = cf2.createConnection();
			conn.start();
			Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			this.conn = conn;
			this.session = session;
			unmarshaller = new UnmarshallerStiri();	
			this.autorId = autorId;
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	public void inregistreazaActiuneStire(final AscultatorActiuniStiri asc) throws JMSException, NamingException{
		Destination dest;
		
		if(consumer != null)
			consumer.close();
		
		dest = (Destination) ctx.lookup("dynamicQueues/"+autorId);
		consumer = session.createConsumer(dest);
		
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message arg0) {
				try {
					String tip = arg0.getStringProperty("tip");
					long stireId = arg0.getLongProperty("stireId");
					
					if(tip.equals("deschis"))
						asc.stireDeschisa(stireId);
					else if(tip.equals("inchis"))
						asc.stireInchisa(stireId);
					
				} catch (JMSException e) {
					e.printStackTrace();
				}	
			}
		});
	}
	public void inchideConn(){
		try {
			conn.close();
		} catch (JMSException e) {
			e.printStackTrace();
		
		}
	}
	
	
}
