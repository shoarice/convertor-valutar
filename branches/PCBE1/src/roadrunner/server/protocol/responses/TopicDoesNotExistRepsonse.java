package roadrunner.server.protocol.responses;

public class TopicDoesNotExistRepsonse extends Response {

	public TopicDoesNotExistRepsonse(String topic) {
		super(61, "The specified topic ("+ topic+") does not exist");
	}

}
