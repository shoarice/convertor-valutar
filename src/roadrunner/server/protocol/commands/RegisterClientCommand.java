package roadrunner.server.protocol.commands;

import roadrunner.server.data.ServerData;
import roadrunner.server.protocol.responses.OkResponse;
import roadrunner.server.protocol.responses.Response;

public class RegisterClientCommand implements Command {

	private String clientName;
	private int id;
	
	public RegisterClientCommand(int id,String name) {
		this.clientName = name;
		this.id = id;
	}

	@Override
	public Response execute() {
		ServerData.instance().addClient(id,clientName);
		return new OkResponse();
	}

	@Override
	public String toString() {
		String str = "Register client" + clientName + " command";
		return str;
	}
	
	

}
