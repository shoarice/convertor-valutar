package roadrunner.server.protocol.responses;

public class EmptyQueueResponse extends Response {
	
	public EmptyQueueResponse() {
		super(12, "No more mails.");
	}
}
