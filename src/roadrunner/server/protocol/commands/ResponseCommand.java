package roadrunner.server.protocol.commands;

import roadrunner.server.protocol.responses.Response;

public class ResponseCommand implements Command {

	private Response response;

	public ResponseCommand(Response response) {
		this.response = response;
	}

	@Override
	public Response execute() {
		return response;
	}

	@Override
	public String toString() {
		return "Command with no exec with response: "+ response.toString();
	}
	
	

}
