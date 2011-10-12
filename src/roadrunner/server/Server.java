package roadrunner.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private int port = 49999;
	private int queueSize = 5;
	private ClientHandler clientHandler;
	
	public Server(){
		port = 49999;
		queueSize = 5;
		clientHandler = new DefaultClientHandler();
		
	}

	public void startServer() throws IOException{
		ServerSocket serverSocket = new ServerSocket(port, queueSize);
		
		Socket clientSocket = null;
		while(true){
			clientSocket = serverSocket.accept();
			clientHandler.handleClient(clientSocket);
		}
		
	}
}
