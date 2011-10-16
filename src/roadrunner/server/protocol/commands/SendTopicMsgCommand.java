package roadrunner.server.protocol.commands;

import roadrunner.server.data.ServerData;
import roadrunner.server.protocol.responses.OkResponse;
import roadrunner.server.protocol.responses.Response;

public class SendTopicMsgCommand implements Command {

	private String msg;
	private String topicDestination;
	private int expireTime;
	
	public SendTopicMsgCommand(String destination, String msg, int expireTime) {
		this.msg = msg;
		this.topicDestination = destination;
		this.expireTime = expireTime;
	}

	@Override
	public Response execute() {
		ServerData.instance().publishTopicMessage(topicDestination, msg, expireTime);
		return new OkResponse();
	}

	@Override
	public String toString() {
		return "Send message topic command: "+ topicDestination +" -> " + msg; 
	}

}
