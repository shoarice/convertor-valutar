package roadrunner.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import roadrunner.server.data.ServerData;
import roadrunner.server.logger.Logger;
import roadrunner.server.protocol.Marshaller;
import roadrunner.server.protocol.Unmarshaller;
import roadrunner.server.protocol.commands.Command;
import roadrunner.server.protocol.responses.Response;

public class ClientThread implements Runnable {

	/**
	 * Folosit pt a identifica un client
	 */
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

	/**
	 * Aici are loc magia
	 */
	@Override
	public void run() {
		try {
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
			
			//unmarshall command
			//execute command
			//get response
			//marshall response
			//send response
			//if response is to terminate conn, exit
			while(true){
				
				//citesc linie de la socket
				String line = in.readLine();
				Logger.log("Received line",line, id);
				
				//construiesc comanda pe baza liniei citite
				Command command = unmarshaller.unmarshall(line);
				Logger.log("Unmarshalled command", command, id);
				
				//execut comanda, care va genera si un raspuns
				Response response = command.execute();
				Logger.log("Response",response, id);
				
				//marshall-uiesc raspunsul
				String responseLine = marshaller.marshall(response);
				Logger.log("Marshalled response",responseLine, id);
				
				Logger.log("", id);
				
				//trimit response marshall-uit
				out.println(responseLine);
				if(response.isCloseConnection())
					break;
				
			}
			
			ServerData.instance().removeClient(id);
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			ServerData.instance().removeClient(id);
			try {
				socket.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

}
