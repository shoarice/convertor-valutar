package roadrunner.server.protocol.commands;

import roadrunner.server.protocol.responses.Response;

public class SendTopicAckCommand extends SendAckCommand {

	public SendTopicAckCommand(String topic) {
		super(topic);
	}

	@Override
	public Response execute() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean wasExecutedSuccesfully() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Command generateSendMsgCommand(String msg) {
		Command command = new SendTopicMsgCommand(destination, msg);
		return command;
	}

	@Override
	public String toString() {
		return "Send Topic Ack Command success: " + success;
	}
	
	

}
