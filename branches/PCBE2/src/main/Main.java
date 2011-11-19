package main;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;



public class Main implements ExceptionListener{

	/**
	 * @param args
	 * @throws JMSException 
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws JMSException, InterruptedException {
		
		new Prod().start();
		new Cons().start();
		
		
	}

	static class Prod extends Thread{

		@Override
		public void run() {
			try {
				Context ctx = new InitialContext();
				ConnectionFactory cf2 = (ConnectionFactory) ctx.lookup("topicConnectionFactory");
				
				Connection conn = cf2.createConnection();
				conn.start();
				
				Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
				
				Destination topicDest = (Destination) ctx.lookup("dynamicTopics/FOO.BAR");
				
				MessageProducer producer = session.createProducer(topicDest);
				producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
				
				Message m = session.createTextMessage("haha");
				
				while(true){
					producer.send(m);
					Thread.sleep(5000);
				}
			}
			catch (Exception e) {
                System.out.println("Caught: " + e);
                e.printStackTrace();
            }
		}
		
	}
	
	static class Cons extends Thread{
		@Override
		public void run() {
			try {
				Context ctx = new InitialContext();
				ConnectionFactory cf2 = (ConnectionFactory) ctx.lookup("topicConnectionFactory");
								
				Connection conn = cf2.createConnection();
				conn.start();
				
				Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
				
				Destination topicDest = (Destination) ctx.lookup("dynamicTopics/FOO.BAR");
				
				MessageConsumer consumer = session.createConsumer(topicDest);
				
				while(true){
					Message m = consumer.receive();
					System.out.println(m.toString());
					Thread.sleep(5000);
				}
			}
			catch (Exception e) {
                System.out.println("Caught: " + e);
                e.printStackTrace();
            }
		}
	}
	@Override
	public synchronized void onException(JMSException exception) {
			exception.printStackTrace();
	}

}
