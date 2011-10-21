package roadrunner.server.protocol.commands;

import roadrunner.server.data.Mail;
import roadrunner.server.data.ServerData;
import roadrunner.server.protocol.responses.Response;
import roadrunner.server.protocol.responses.SendQueueResponse;

public class ReadFromQueueCommand implements Command {

	private int id;

	public ReadFromQueueCommand(int id) {
		this.id = id;
	}

	@Override
	public Response execute() {
		Mail mail = ServerData.instance().getOldestMailMessage(id);
		return new SendQueueResponse(mail);
	}
	
	@Override
	public String toString() {
		return "Read from queue " + id + " command";
	}

}
