package org.baltoaca.CommandLineParser;

import java.io.Console;

import org.baltoaca.CommandLineParser.exceptions.ConsoleNotFoundException;
import org.baltoaca.CommandLineParser.exceptions.ExecutorNotFoundException;

/**
 * Basic implementation of a command line interface.
 * It parses the input, separates it by the "space" delimiter
 * and passes it to an Executor.
 * The executor can also return a response which will be printed
 * to the screen.
 * @author VlaD
 *
 */
public class CommandLineParser {
	private static CommandLineParser parser = null;
	private Executor executor;
	Console console = System.console();
	
	private CommandLineParser(){}
	
	public static CommandLineParser instance(){
		if(parser == null)
			parser = new CommandLineParser();
		
		return parser;
	}
	
	
	public void run() throws ConsoleNotFoundException, ExecutorNotFoundException{
		String commandLine = null;
		String[] commandElements = null; 
		
		if(consoleNotFound())
			throw new ConsoleNotFoundException();
		
		writePrompt();
		while((commandLine=console.readLine()) !=null){
			commandElements = extractCommands(commandLine);
			
			if(executorNotFound())
				throw new ExecutorNotFoundException();
			
			String response = executor.executeAndGenerateResponse(commandElements);			
			if(responseIsNotEmpty(response))
				console.printf(response);
			
			writePrompt();
		}
	}

	private void writePrompt(){
		console.printf("> ");
	}
	
	private boolean consoleNotFound() {
		if(console == null)
			return true;
		return false;
	}
	
	private String[] extractCommands(String commandLine) {
		String[] commandsElements;
		commandsElements = commandLine.split("[\\s\\t]+");
		return commandsElements;
	}
	
	private boolean executorNotFound() {
		if(executor == null)
			return true;
		return false;
	}
	
	private boolean responseIsNotEmpty(String response) {
		if(response == null)
			return false;
		if(response.equalsIgnoreCase(""))
			return false;
		
		return true;
	}

	public void setExecutor(Executor executor) {
		this.executor = executor;
	}
	
	
}
