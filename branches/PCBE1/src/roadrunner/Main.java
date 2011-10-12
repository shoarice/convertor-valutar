package roadrunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import roadrunner.server.Server;
import roadrunner.server.ServerConfiguration;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ServerConfiguration serverConfiguration = parseArguments(args);
		try {
			new Server(serverConfiguration).startServer();
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	private static ServerConfiguration parseArguments(String[] args) {
		if(args.length%2 != 0){
			System.out.println("Invalid arguments");
			System.exit(1);
		}
		
		ServerConfiguration config = new ServerConfiguration();
		Map<String,String> argsMap = buildArgsMap(args);
		
		//****** PORT ***********
		if(argsMap.containsKey("-p")){
			try{
				Integer port = Integer.parseInt(argsMap.get("-p"));
				
				if(port < 1 || port > 65535)
					throw new NumberFormatException();
				if(port < 1025)
					System.out.println("Warning: ports under 1024 are usually reserved");
				
				config.setPort(port);
			}catch(NumberFormatException e){
				System.out.println("Port value invalid. Default value was used!");
			}
		}
		
		//****** SOCKET QUEUE SIZE ***********
		if(argsMap.containsKey("-sq")){
			try{
				Integer socketQueueSize = Integer.parseInt(argsMap.get("-sq"));
				if(socketQueueSize < 1)
					throw new NumberFormatException();
			}catch(NumberFormatException e){
				System.out.println("Socket queue size invalid. Default value was used!");
			}
		}
		
		return config;
	}

	private static Map<String,String> buildArgsMap(String[] args) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		for(int i=0; i < args.length; i=i+2){
			map.put(args[i], args[i+1]);
		}
		
		return map;
	}
}