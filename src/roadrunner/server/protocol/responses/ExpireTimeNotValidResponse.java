package roadrunner.server.protocol.responses;

public class ExpireTimeNotValidResponse extends Response {

	public ExpireTimeNotValidResponse() {
		super(66, "Expire time is not valid");
	}
 
}
