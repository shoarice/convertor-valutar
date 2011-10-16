package roadrunner.server.protocol;

import roadrunner.server.protocol.commands.Command;
import roadrunner.server.protocol.commands.QuitCommand;
import roadrunner.server.protocol.commands.ReadFromQueueCommand;
import roadrunner.server.protocol.commands.ReadFromTopicCommand;
import roadrunner.server.protocol.commands.RegisterClientCommand;
import roadrunner.server.protocol.commands.ResponseCommand;
import roadrunner.server.protocol.commands.SendAckCommand;
import roadrunner.server.protocol.commands.SendQueueAckCommand;
import roadrunner.server.protocol.commands.SendTopicAckCommand;
import roadrunner.server.protocol.responses.UnsupportedResponse;



public class Unmarshaller {
	private int id;
	private static String[] keywords= {"REGISTER", "READMSG", "SENDMSG", "QUIT"};
	private SendAckCommand sendAckCommand;
	
	public Unmarshaller(int clientId) {
		this.id = clientId;
	}

	/**
	 * Si aici e magie...
	 * @param line
	 * @return
	 */
	public Command unmarshall(String line) {
		Command command = null;
		
		//impart linia citita de la socket dupa spatii
		String[] split = line.split(" ");
		int len = split.length;
		
		if(len >= 1){
			//REGISTER
			if(split[0].equalsIgnoreCase(keywords[0])){
				command = unmarshallRegister(split, len);
			//READMSG
			}else if(split[0].equalsIgnoreCase(keywords[1])){
				command = unmarshallReadMsg(command, split, len);
			//SENDMSG
			}else if(split[0].equalsIgnoreCase(keywords[2])){
				command = unmarshallSendCommand(line, split, len);
			//QUIT
			}else if(split[0].equalsIgnoreCase(keywords[3])){
				command = new QuitCommand(id);
			}
		}
		
		if(command == null)
			command = getUnsupportedResponseCommand();
		
		return command;
	}

	private Command unmarshallRegister(String[] split, int len) {
		Command command = null;
		if(len == 2){
			String name = split[1];
			command = new RegisterClientCommand(id,name); //construieste comanda register client (trimitem id si nume)
		}
		return command;
	}

	private Command unmarshallReadMsg(Command command, String[] split, int len) {
		if(len >= 2){
			String messageType = split[1];
			
			if(messageType.equalsIgnoreCase("QUEUE")){
				//construim comanda read form queue care foloseste 
				//id-ul ca sa citeasca din queue-ul clientului care trimite comanda
				command = new ReadFromQueueCommand(id); 
			
			}else if(messageType.equalsIgnoreCase("TOPIC")){
				if(len == 3){
					String topicName = split[2];
					command = new ReadFromTopicCommand(topicName);
				}
			}
		}
		return command;
	}

	/**
	 * Server-ul nu se asteapt ca mesajul efectiv sa ajunga imediat dupa ce primeste comanda
	 * de sendmsg
	 * @param line
	 * @param split
	 * @param len
	 * @return
	 */
	private Command unmarshallSendCommand(String line, String[] split, int len) {
		Command command = null;
		if(sendAckCommand != null){
			if(sendAckCommand.wasExecutedSuccesfully()){
				String[] newSplit = line.split(" ", 2);
				if(newSplit.length == 2)
					command = sendAckCommand.generateSendMsgCommand(newSplit[1]);
				sendAckCommand = null;
			}
		}else
		if(len >= 3){
			String messageType = split[1];
			
			if(messageType.equalsIgnoreCase("QUEUE")){
				String client = split[2];
				command = sendAckCommand = new SendQueueAckCommand(client);
			}else if(messageType.equalsIgnoreCase("TOPIC")){
				if(len == 4){
					String topic = split[2];
					try{
						int expireTime = Integer.parseInt(split[3]);
						command = sendAckCommand = new SendTopicAckCommand(topic, expireTime);
					}
					catch (NumberFormatException e) {
						//se returneaza automat null
					}
				}
			}
		}
		return command;
	}

	private ResponseCommand getUnsupportedResponseCommand() {
		return new ResponseCommand(new UnsupportedResponse());
	}

}
