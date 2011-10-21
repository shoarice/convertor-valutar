package roadrunner.server.protocol.commands;

import roadrunner.server.data.ServerData;
import roadrunner.server.protocol.responses.InexistentClientResponse;
import roadrunner.server.protocol.responses.OkResponse;
import roadrunner.server.protocol.responses.Response;

public class SendQueueAckCommand extends SendAckCommand {

	private int sender_id;
	
	public SendQueueAckCommand(int sender_id, String client) {
		super(client);
		this.sender_id = sender_id;
	}

	@Override
	public Response execute() {
		if (ServerData.instance().ownerExists(destination))
		{
			success = true;
			return new OkResponse();
		}
		else
		{
			success = false;
			return new InexistentClientResponse();
		}
	}

	@Override
	public boolean wasExecutedSuccesfully() {
		return success;
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
