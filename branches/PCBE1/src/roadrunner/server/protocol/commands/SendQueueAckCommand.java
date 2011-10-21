package roadrunner.server.protocol.commands;

import roadrunner.server.protocol.responses.Response;

public class SendQueueAckCommand extends SendAckCommand {

	private int sender_id;
	
	public SendQueueAckCommand(int sender_id, String client) {
		super(client);
		this.sender_id = sender_id;
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
		Command command = new SendQueueMsgCommand(sender_id, destination,msg);
		return command;
	}
	
	@Override
	public String toString() {
		return "Send Queue Ack Command success: " + success;
	}
	

}
