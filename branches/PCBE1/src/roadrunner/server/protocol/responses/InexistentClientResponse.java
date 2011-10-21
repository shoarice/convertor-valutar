package roadrunner.server.protocol.responses;

public class InexistentClientResponse extends Response {

	public InexistentClientResponse() {
		super(80, "This recipient does not exist");
	}

}
