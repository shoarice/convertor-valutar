package roadrunner.server.protocol.commands;

import roadrunner.server.data.ServerData;
import roadrunner.server.protocol.responses.InexistentClientResponse;
import roadrunner.server.protocol.responses.OkResponse;
import roadrunner.server.protocol.responses.Response;

public class SendQueueMsgCommand implements Command {

	private String msg;
	private String clientDestination;
	private int sender_id;

	public SendQueueMsgCommand(int sender_id, String destination, String msg) {
		this.clientDestination = destination;
		this.msg = msg;
		this.sender_id = sender_id;
	}

	@Override
	public Response execute() {
		if (ServerData.instance().ownerExists(clientDestination))
		{
			ServerData.instance().deliverMailMessage(clientDestination, msg, sender_id);
			return new OkResponse();
		}
		else
		{
			return new InexistentClientResponse();
		}
		
	}
	
	@Override
	public String toString() {
		return "Send message queue command: "+ clientDestination +" -> " + msg; 
	}
}
