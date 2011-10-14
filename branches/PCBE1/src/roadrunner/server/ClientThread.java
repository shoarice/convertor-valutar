package roadrunner.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import roadrunner.server.logger.Logger;
import roadrunner.server.protocol.Marshaller;
import roadrunner.server.protocol.Unmarshaller;
import roadrunner.server.protocol.commands.Command;
import roadrunner.server.protocol.responses.Response;

public class ClientThread implements Runnable {

	private int id;
	private Socket socket;
	private Unmarshaller unmarshaller;
	private Marshaller marshaller;
	
	public ClientThread(Socket clientSocket, int id) {
		socket = clientSocket;
		this.id = id;
		init();
	}

	private void init() {
		unmarshaller = new Unmarshaller(id);
		marshaller = new Marshaller();
	}

	@Override
	public void run() {
		try {
/*			new PrintWriter(socket.getOutputStream(), true).println("Ceau bah!");
			System.out.println(new BufferedReader(new InputStreamReader(socket.getInputStream())).readLine());
			socket.close();*/
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			
			//unmarshall command
			//execute command
			//get response
			//marshall response
			//if response is to terminate conn, exit
			while(true){
				String line = in.readLine();
				Logger.log("Received line",line, id);
				
				Command command = unmarshaller.unmarshall(line);
				Logger.log("Unmarshalled command", command, id);
				
				Response response = command.execute();
				Logger.log("Response",response, id);
				
				String responseLine = marshaller.marshall(response);
				Logger.log("Marshalled response",responseLine, id);
				
				out.println(responseLine);
				if(response.isCloseConnection())
					break;
			}
			
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
