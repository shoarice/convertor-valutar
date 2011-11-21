package main;
import java.util.Calendar;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.naming.NamingException;

import model.Stire;
import actori.AscultatorActiuniStiri;
import actori.AscultatorStiri;
import actori.PublicatorActiuniStiri;
import actori.PublicatorStiri;
import actori.ReceptorActiuniStiri;
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
				s.setAutor("autor");
				s.setStire("text stire");
				s.setSursa("sursa");
				s.setAutorId(1);
				
				ReceptorActiuniStiri rec = new ReceptorActiuniStiri(1);
				rec.inregistreazaActiuneStire(new AscultatorActiuniStiri() {
					
					@Override
					public void stireInchisa(int stireId) {
						System.out.println("1 - Stire "+stireId+" inchisa");
					}
					
					@Override
					public void stireDeschisa(int stireId) {
						System.out.println("1 - Stire "+stireId+" deschisa");
					}
				});
				
				while(true){
					s.setDataCreat(Calendar.getInstance().getTime());
					s.setDataModificat(Calendar.getInstance().getTime());
					
					p.publicareStire(s, "meteo");
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
		
		public Cons(int i) {
			this.i = i;
		}

		@Override
		public void run() {
			try {
				
				final PublicatorActiuniStiri p = new PublicatorActiuniStiri();
				ReceptorStiri r = new ReceptorStiri();
				r.inregistreazaAscultatorStiri("meteo", new AscultatorStiri() {
					
					@Override
					public void laStire(Stire stire, String tip) {
						p.trimiteStireDeschisa(stire.getStireId(),stire.getAutorId());
						System.out.println(i+" "+tip+""+stire);
						p.trimiteStireInchisa(stire.getStireId(),stire.getAutorId());
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
