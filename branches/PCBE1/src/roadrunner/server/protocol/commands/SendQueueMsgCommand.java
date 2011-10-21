package roadrunner.server.protocol.commands;

import roadrunner.server.protocol.responses.Response;

public class SendQueueMsgCommand implements Command {

	private String msg;
	private String clientDestination;

	public SendQueueMsgCommand(String destination, String msg) {
		this.clientDestination = destination;
		this.msg = msg;
	}

	@Override
	public Response execute() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		return "Send message queue command: "+ clientDestination +" -> " + msg; 
	}
}
