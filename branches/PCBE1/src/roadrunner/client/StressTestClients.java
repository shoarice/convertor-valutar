package roadrunner.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Random;

public class StressTestClients {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		for(int i=0;i < 100;i++){
			new Thread(){

				@Override
				public void run() {
					try {
						Socket sock = new Socket("127.0.0.1", 49999);
						BufferedReader in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
						PrintWriter out = new PrintWriter(sock.getOutputStream(), true);
						Random rand = new Random();
						
						while(true){
							if(rand.nextInt(3) == 0){
								out.println("sendmsg topic "+rand.nextInt(5) +" "+ 1+rand.nextInt(5));
								in.readLine();
								out.println("sendmsg mesaj");
								in.readLine();
								out.println("sendmsg queue "+"ionel");
								in.readLine();
								out.println("sendmsg mail_mail_mail");
								in.readLine();
							}
							else{
								out.println("readmsg topic "+rand.nextInt(5));
								in.readLine();
								out.println("readmsg queue ionel");
								in.readLine();
							}
						}
					} catch (UnknownHostException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				
			}.start();
		}
			
	}

}
