package roadrunner.server.protocol.responses;


public class UnsupportedResponse extends Response {

	public UnsupportedResponse() {
		super(20, "Command not supported");
	}

}
