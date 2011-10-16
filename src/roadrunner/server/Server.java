package roadrunner.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import roadrunner.server.data.ServerData;

public class Server {
	
	private ServerConfiguration config;
	private ClientHandler clientHandler;
	
	public Server(){
		config = new ServerConfiguration();
		clientHandler = new DefaultClientHandler();
		ServerData.instance().setGlobalTopicExpireTime(config.getGlobalExpireTime());
	}

	public Server(ClientHandler clientHandler){
		this();
		this.clientHandler = clientHandler;
	}
	
	public Server(ServerConfiguration config){
		this();
		this.config = config;
	}
	
	public Server(ServerConfiguration config, ClientHandler clientHandler){
		this.config = config;
		this.clientHandler = clientHandler;
		ServerData.instance().setGlobalTopicExpireTime(config.getGlobalExpireTime());
	}
	
	public void startServer() throws IOException{
		ServerSocket serverSocket = new ServerSocket(config.getPort(), config.getSocketQueueSize());
		
		Socket clientSocket = null;
		while(true){
			clientSocket = serverSocket.accept();
			clientHandler.handleClient(clientSocket);
		}
		
	}
}
