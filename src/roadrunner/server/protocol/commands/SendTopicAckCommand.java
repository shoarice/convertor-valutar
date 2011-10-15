package roadrunner.server.protocol.commands;

import roadrunner.server.protocol.responses.OkResponse;
import roadrunner.server.protocol.responses.Response;

public class SendTopicAckCommand extends SendAckCommand {

	public SendTopicAckCommand(String topic) {
		super(topic);
	}

	@Override
	public Response execute() {
		success = true;
		return new OkResponse();
	}

	@Override
	public boolean wasExecutedSuccesfully() {
		return success;
	}

	@Override
	public Command generateSendMsgCommand(String msg) {
		Command command = new SendTopicMsgCommand(destination, msg);
		return command;
	}

	@Override
	public String toString() {
		return "Send Topic Ack Command";
	}
	
	

}
