package roadrunner.server.protocol.responses;

public class ClientExistsResponse extends Response {

	public ClientExistsResponse(String name) {
		super(21, "The specified client name ("+name+") already exists");
	}

}
