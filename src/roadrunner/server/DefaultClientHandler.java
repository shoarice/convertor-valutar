package roadrunner.server;

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DefaultClientHandler implements ClientHandler {
	
	private ExecutorService executorsPool;
	private static int id;
	
	public DefaultClientHandler(){
		executorsPool = Executors.newCachedThreadPool();
	}
	
	@Override
	public void handleClient(Socket clientSocket) {
		
		ClientThread clientThread = new ClientThread(clientSocket,++id);
		executorsPool.execute(clientThread);
	}

}
