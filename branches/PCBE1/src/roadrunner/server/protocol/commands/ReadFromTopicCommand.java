package roadrunner.server.protocol.commands;

import roadrunner.server.protocol.responses.Response;

public class ReadFromTopicCommand implements Command {

	private String topic;

	public ReadFromTopicCommand(String topicName) {
		this.topic = topicName;
	}

	@Override
	public Response execute() {
		return null;
	}

	@Override
	public String toString() {
		String str = "Read from topic " + topic + " command";
		return str;
	}
}
