package roadrunner.server.protocol.commands;

import roadrunner.server.protocol.responses.Response;

public interface Command {

	public Response execute();

}
