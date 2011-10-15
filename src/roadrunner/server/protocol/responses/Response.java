package roadrunner.server.protocol.responses;

public abstract class Response {

	private int code;
	protected String description;
	private boolean closeConnection;
	
	public Response(int code, String description){
		this.code = code;
		this.description = description;
		closeConnection = false;
	}
	
	public Response(int code, String description, boolean closeConnection){
		this(code, description);
		this.closeConnection = closeConnection;
	}
	
	public boolean isCloseConnection() {
		return closeConnection;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(String.valueOf(code));
		sb.append(" ").append(description);
		
		if(closeConnection)
			sb.append(" --close connection");
		
		return sb.toString();
	}
	
	

}
