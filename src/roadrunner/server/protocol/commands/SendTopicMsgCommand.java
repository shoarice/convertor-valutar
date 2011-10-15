package roadrunner.server.protocol.commands;

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
		// TODO Auto-generated method stub
		return null;
	}

}
