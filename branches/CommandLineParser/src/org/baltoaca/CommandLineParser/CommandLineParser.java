package org.baltoaca.CommandLineParser;

import java.io.Console;

import exceptions.ConsoleNotFoundException;

public class CommandLineParser {
	private static CommandLineParser parser = null;
	private Executor executor;
	private CommandLineParser(){}
	
	public static CommandLineParser instance(){
		if(parser == null)
			parser = new CommandLineParser();
		
		return parser;
	}
	
	
	public void run() throws ConsoleNotFoundException{
		Console console = System.console();
		String commandLine = null;
		String[] commandsElements = null; 
		
		if(consoleNotFound(console))
			throw new ConsoleNotFoundException();
		
		writePrompt(console);
		while((commandLine=console.readLine())!=null){
			commandsElements = extractCommands(commandLine);
			
			String response = executor.executeAndGenerateAnswer(commandsElements);			
			console.printf(response);
			
			writePrompt(console);
		}
	}

	private void writePrompt(Console console){
		console.printf("> ");
	}
	
	private boolean consoleNotFound(Console console) {
		if(console == null)
			return true;
		return false;
	}
	
	private String[] extractCommands(String commandLine) {
		String[] commandsElements;
		commandsElements = commandLine.split("[\\s\\t]+");
		return commandsElements;
	}

}
