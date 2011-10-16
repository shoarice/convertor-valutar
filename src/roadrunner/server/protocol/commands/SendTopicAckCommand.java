package roadrunner.server.protocol.commands;

import roadrunner.server.protocol.responses.ExpireTimeNotValidResponse;
import roadrunner.server.protocol.responses.OkResponse;
import roadrunner.server.protocol.responses.Response;

public class SendTopicAckCommand extends SendAckCommand {

	private int expireTime;

	public SendTopicAckCommand(String topic, int expireTime) {
		super(topic);
		this.expireTime = expireTime;
	}

	@Override
	public Response execute() {
		if(expireTime > 0){
			success = true;
			return new OkResponse();
		}
		else{
			success = false;
			return new ExpireTimeNotValidResponse();
		}
	}

	@Override
	public boolean wasExecutedSuccesfully() {
		return success;
	}

	@Override
	public Command generateSendMsgCommand(String msg) {
		Command command = new SendTopicMsgCommand(destination, msg, expireTime);
		return command;
	}

	@Override
	public String toString() {
		return "Send Topic Ack Command expire time: "+ expireTime;
	}
	
	

}
