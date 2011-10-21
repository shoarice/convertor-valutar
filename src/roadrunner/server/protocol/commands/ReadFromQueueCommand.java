package roadrunner.server.protocol.commands;

import roadrunner.server.data.Mail;
import roadrunner.server.data.ServerData;
import roadrunner.server.protocol.responses.EmptyQueueResponse;
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
		if (mail != null) {
			return new SendQueueResponse(mail);
		}
		return new EmptyQueueResponse();
	}
	
	@Override
	public String toString() {
		return "Read from queue " + id + " command";
	}

}
