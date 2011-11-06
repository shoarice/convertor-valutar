package roadrunner.server;

public class ServerConfiguration{
	private int port;
	private int socketQueueSize;
	private int globalExpireTime;
	//altele
	
	//DEFAULT VALUES
	public ServerConfiguration(){
		port = 49989;
		socketQueueSize = 5;
		globalExpireTime = 120;
	}

	public int getSocketQueueSize() {
		return socketQueueSize;
	}

	public int getPort() {
		return port;
	}
	
	public int getGlobalExpireTime() {
		return globalExpireTime;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public void setSocketQueueSize(int socketQueueSize) {
		this.socketQueueSize = socketQueueSize;
	}
	
	public void setGlobalExpireTime(int expireTime) {
		globalExpireTime = expireTime; 
	}


	
	
	
}