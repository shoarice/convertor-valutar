package roadrunner.server.protocol.commands;

import roadrunner.server.data.ServerData;
import roadrunner.server.protocol.responses.OkResponse;
import roadrunner.server.protocol.responses.Response;

public class SendTopicMsgCommand implements Command {

	private String msg;
	private String topicDestination;
	
	public SendTopicMsgCommand(String destination, String msg) {
		this.msg = msg;
		this.topicDestination = destination;
	}

	@Override
	public Response execute() {
		ServerData.instance().publishTopicMessage(topicDestination, msg);
		return new OkResponse();
	}

	@Override
	public String toString() {
		return "Send message topic command: "+ topicDestination +" -> " + msg; 
	}

}
