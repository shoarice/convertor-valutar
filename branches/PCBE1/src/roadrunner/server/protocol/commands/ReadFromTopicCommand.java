package roadrunner.server.protocol.commands;

import java.util.List;

import roadrunner.server.data.ServerData;
import roadrunner.server.protocol.responses.Response;
import roadrunner.server.protocol.responses.SendTopicResponse;
import roadrunner.server.protocol.responses.TopicDoesNotExistRepsonse;

public class ReadFromTopicCommand implements Command {

	private String topic;

	public ReadFromTopicCommand(String topicName) {
		this.topic = topicName;
	}

	@Override
	public Response execute() {
		if(ServerData.instance().topicExists(topic)){
			List<String> msgs = ServerData.instance().getTopicMessages(topic);
			return new SendTopicResponse(msgs);
		}else
			return new TopicDoesNotExistRepsonse(topic);
	}

	@Override
	public String toString() {
		String str = "Read from topic " + topic + " command";
		return str;
	}
}
