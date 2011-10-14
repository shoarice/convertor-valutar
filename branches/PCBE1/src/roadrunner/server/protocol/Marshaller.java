package roadrunner.server.protocol;

import roadrunner.server.protocol.responses.Response;

public class Marshaller {

	public String marshall(Response response) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(response.getCode()));
		sb.append(" ");
		sb.append(response.getDescription());
		
		return sb.toString();
	}

}
