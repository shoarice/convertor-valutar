package roadrunner.server.protocol.responses;

import java.util.List;

public class SendTopicResponse extends Response {

	public SendTopicResponse(List<String> msgs) {
		super(60, "");
		
		StringBuffer sb = new StringBuffer("MESSAGES");
		for (String string : msgs) {
			sb.append("\\x");
			sb.append(string);
		}
		
		description =  sb.toString();
	}
}
