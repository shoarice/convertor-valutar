package roadrunner.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread implements Runnable {

	private Socket socket;
	
	public ClientThread(Socket clientSocket) {
		socket = clientSocket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			new PrintWriter(socket.getOutputStream(), true).println("Ceau bah!");
			System.out.println(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine());
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
