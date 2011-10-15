package roadrunner.server.protocol.commands;

import roadrunner.server.protocol.responses.Response;

public class SendQueueAckCommand extends SendAckCommand {

	public SendQueueAckCommand(String client) {
		super(client);
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
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return "Send Queue Ack Command success: " + success;
	}
	

}
