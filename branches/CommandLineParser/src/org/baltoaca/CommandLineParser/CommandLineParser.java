package org.baltoaca.CommandLineParser;

import java.io.Console;

import exceptions.ConsoleNotFoundException;

public class CommandLineParser {
	private static CommandLineParser parser = null;
	
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
		
		isConsoleAvailable(console);
		
		writePrompt(console);
		while((commandLine=console.readLine())!=null){
			commandsElements = extractCommands(commandLine);
			
			
			writePrompt(console);
		}
	}

	private void writePrompt(Console console){
		console.printf("action > ");
	}
	
	private void isConsoleAvailable(Console console) throws ConsoleNotFoundException {
		if(console == null)
			throw new ConsoleNotFoundException();
	}
	
	private String[] extractCommands(String commandLine) {
		String[] commandsElements;
		commandsElements = commandLine.split("[\\s\\t]+");
		return commandsElements;
	}

}
