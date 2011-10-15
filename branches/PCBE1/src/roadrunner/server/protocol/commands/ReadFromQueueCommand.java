package roadrunner.server.protocol.commands;

import roadrunner.server.protocol.responses.Response;

public class ReadFromQueueCommand implements Command {

	private int id;

	public ReadFromQueueCommand(int id) {
		this.id = id;
	}

	@Override
	public Response execute() {
		return null;
	}
	
	@Override
	public String toString() {
		return "Read from queue command";
	}

}
