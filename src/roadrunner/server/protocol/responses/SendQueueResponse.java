package roadrunner.server.protocol.responses;

import roadrunner.server.data.Mail;

public class SendQueueResponse extends Response {
	
	public SendQueueResponse(Mail mail) {
		super(17, "");
		
		description = mail.toString();
	}
}
