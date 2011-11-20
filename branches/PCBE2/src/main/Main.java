package main;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import model.Stire;
import model.UnmarshallerStiri;
import actori.AscultatorDeStiri;
import actori.PublicatorStiri;
import actori.ReceptorStiri;



public class Main implements ExceptionListener{

	/**
	 * @param args
	 * @throws JMSException 
	 * @throws InterruptedException 
	 * @throws NamingException 
	 */
	public static void main(String[] args) throws JMSException, InterruptedException, NamingException {
		
		new Prod().start();
		new Cons(1).start();
		new Cons(2).start();
		
	}

	static class Prod extends Thread{
		private static PublicatorStiri p = new PublicatorStiri();
		
		@Override
		public void run() {
			try {
				
				Stire s = new Stire();
				s.setAutor("autor2");
				s.setStire("text stire");
				s.setSursa("sursa");
				
				while(true){
					s.setDataCreat(Calendar.getInstance().getTime());
					s.setDataModificat(Calendar.getInstance().getTime());
					
					p.publicaStire(s, "meteo");
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
		private int i;
		private static UnmarshallerStiri um= new UnmarshallerStiri();
		
		public Cons(int i) {
			this.i = i;
		}

		@Override
		public void run() {
			try {
				
				ReceptorStiri r = new ReceptorStiri();
				r.inregistreazaAscultatorDeMesaje("meteo", new AscultatorDeStiri() {
					
					@Override
					public void laStire(Stire stire) {
						System.out.println(i+" "+stire);
					}
				});
				
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
