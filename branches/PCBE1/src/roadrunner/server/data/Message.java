package roadrunner.server.data;

public class Message {
	private String msg;
	private long postedTime;
	private long expireInterval;
	private boolean globalExpiration;
	private boolean localExpiration;
	
	public Message(String msg, int expireTime){
		this.msg = msg;
		this.expireInterval = expireTime;
		postedTime = System.nanoTime()/1000000; //mili
	}
	
	public boolean isExpired(int globalExpireInterval){
		
		long now = System.nanoTime()/1000000;
		
		long timePassed = now - postedTime;
		long expireGlobalInterval = globalExpireInterval*1000;
		long expireLocalInterval = expireInterval*1000;
		
		if(timePassed >=  expireGlobalInterval){
			globalExpiration = true;
			return true;
		}else
		if(timePassed >= expireLocalInterval){
			localExpiration = true;
			return true;			
		}
		
		return false;
	}

	public String getMsg() {
		return msg;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("Message ");
		sb.append(msg);
		sb.append(" expire time=");
		sb.append(expireInterval);
		sb.append(" expired ");
		if(globalExpiration)
			sb.append("global time");
		if(localExpiration)
			sb.append("local time");
		return sb.toString();
	}
	
	
}
