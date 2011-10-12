package roadrunner.server;

public class ServerConfiguration{
	private int port;
	private int socketQueueSize;
	//altele
	
	public ServerConfiguration(){
		port = 49999;
		socketQueueSize = 5;
	}

	public int getSocketQueueSize() {
		return socketQueueSize;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setSocketQueueSize(int socketQueueSize) {
		this.socketQueueSize = socketQueueSize;
	}
	
	
	
}