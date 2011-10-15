package roadrunner.server.protocol.commands;

import roadrunner.server.protocol.responses.Response;

public abstract class SendAckCommand implements Command{
	protected String destination;
	protected boolean success;

	public SendAckCommand(String destination) {
		this.destination = destination;
	}

	@Override
	public abstract Response execute();
	
	public abstract boolean wasExecutedSuccesfully();

	public abstract Command generateSendMsgCommand(String msg);

}
