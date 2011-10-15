package roadrunner.server.protocol.commands;

import roadrunner.server.data.ServerData;
import roadrunner.server.protocol.responses.ClientExistsResponse;
import roadrunner.server.protocol.responses.OkResponse;
import roadrunner.server.protocol.responses.Response;
import roadrunner.server.protocol.responses.UnsupportedResponse;

public class RegisterClientCommand implements Command {

	private String clientName;
	private int id;
	
	public RegisterClientCommand(int id,String name) {
		this.clientName = name;
		this.id = id;
	}

	@Override
	public Response execute() {
		if(ServerData.instance().isNameTaken(clientName))
			return new ClientExistsResponse(clientName);
		
		String savedName = ServerData.instance().getClient(id);
		if(savedName != null)
			return new UnsupportedResponse();
		
		ServerData.instance().addClient(id,clientName);
		return new OkResponse();
	}

	@Override
	public String toString() {
		String str = "Register client " + clientName + " command";
		return str;
	}
	
	

}
