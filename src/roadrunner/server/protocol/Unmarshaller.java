package roadrunner.server.protocol;

import roadrunner.server.data.ServerData;
import roadrunner.server.protocol.commands.Command;
import roadrunner.server.protocol.commands.QuitCommand;
import roadrunner.server.protocol.commands.RegisterClientCommand;
import roadrunner.server.protocol.commands.ResponseCommand;
import roadrunner.server.protocol.responses.ClientExistsResponse;
import roadrunner.server.protocol.responses.UnsupportedResponse;



public class Unmarshaller {
	private int id;
	private static String[] keywords= {"REGISTER", "READMSG", "SENDMSG", "QUIT"};
	
	public Unmarshaller(int clientId) {
		this.id = clientId;
	}

	public Command unmarshall(String line) {
		Command command = null;
		
		String[] split = line.split(" ");
		int len = split.length;
		
		if(len >= 1){
			//REGISTER
			if(split[0].equalsIgnoreCase(keywords[0])){
				if(len == 2){
					String name = split[1];
					
					if(ServerData.instance().isNameTaken(name))
						command = new ResponseCommand(new ClientExistsResponse(name));
					else{
						command = new RegisterClientCommand(id,name);
					}
				
				//command not valid
				}else {
					command = getUnsupportedResponseCommand();
				}
				
			//READMSG
			}else if(split[0].equalsIgnoreCase(keywords[1])){
				
			//SENDMSG
			}else if(split[0].equalsIgnoreCase(keywords[2])){
				
			//QUIT
			}else if(split[0].equalsIgnoreCase(keywords[3])){
				command = new QuitCommand(id);
			}else {
				command = getUnsupportedResponseCommand();
			}
			
		//command not valid
		}else
			command = getUnsupportedResponseCommand(); 
		
		return command;
	}

	private ResponseCommand getUnsupportedResponseCommand() {
		return new ResponseCommand(new UnsupportedResponse());
	}

}
