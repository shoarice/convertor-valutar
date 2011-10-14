package roadrunner.server.protocol.commands;

import roadrunner.server.data.ServerData;
import roadrunner.server.protocol.responses.ByeResponse;
import roadrunner.server.protocol.responses.Response;

public class QuitCommand implements Command {

	private int id;

	public QuitCommand(int id) {
		this.id = id;
	}

	@Override
	public Response execute() {
		ServerData.instance().removeClient(id);
		return new ByeResponse();
	}

	@Override
	public String toString() {
		return "Quit command";
	}
	
	

}
