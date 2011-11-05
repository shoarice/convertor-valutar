package roadrunner.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class StressTestClientsQueue 
{
public static void testQueue() throws InterruptedException {
		
	final String[] names = {"Alina", "Grigore", "Alex", "Bogdan", "Matei"};

	new Thread()
		{

			@Override
			public void run() {
					Socket sock;
					try {
					    sock = new Socket("127.0.0.1", 49989);
						BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
						PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
						out.println("REGISTER "+names[1]);
					    in.readLine();
					    
					    while (true)
					    {
					    	Thread.sleep(1000);
					    	out.println("readmsg queue");
					    	in.readLine();
					    }
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
			}
			
		}.start();
		
		new Thread()
		{

			@Override
			public void run() {
					Socket sock;
					try {
					    sock = new Socket("127.0.0.1", 49989);
						BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
						PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
						out.println("REGISTER "+names[2]);
						in.readLine();
					    
					    while (true)
					    {
					    	Thread.sleep(1500);
					    	out.println("readmsg queue");
					    	in.readLine();
					    }
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
			}
			
		}.start();
		
		new Thread()
		{

			@Override
			public void run() {
					Socket sock;
					try {
					    sock = new Socket("127.0.0.1", 49989);
						BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
						PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
						out.println("REGISTER "+names[3]);
						in.readLine();
					    
					    while (true)
					    {
					    	
					    	Thread.sleep(2000);
					    	out.println("readmsg queue");
					    	in.readLine();
					    }
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
			}
			
		}.start();
		
		new Thread()
		{

			@Override
			public void run() {
					Socket sock;
					try {
					    sock = new Socket("127.0.0.1", 49989);
						BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
						PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
						out.println("REGISTER "+names[4]);
						in.readLine();
						    
						    while (true)
						    {
						    	Thread.sleep(1000);
						    	out.println("readmsg queue");
						    	in.readLine();
						    }
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
			}
			
		}.start();
		
		new Thread()
		{

			@Override
			public void run() {
					Socket sock;
					try {
					    sock = new Socket("127.0.0.1", 49989);
						BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
						PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
						out.println("REGISTER "+names[0]);
						in.readLine();
						    
						    while (true)
						    {
						    	Thread.sleep(1200);
						    	out.println("readmsg queue");
						    	in.readLine();
						    }
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	
			}
			
		}.start();
	
	
	for(int i=0;i < 100;i++){
			
			
			new Thread(){

				@Override
				public void run() {
					
					try {
						Socket sock = new Socket("127.0.0.1", 49989);
						BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
						PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
						Random rand = new Random();
					
					    while(true)
					    {
								out.println("sendmsg queue "+names[rand.nextInt(5)]);
								out.println("sendmsg mail_mai l_mail");
								in.readLine();	
						}
							
						
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}.start();
			Thread.sleep(500);
		}
			
	}
}
