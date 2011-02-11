package org.baltoaca;
import org.baltoaca.CommandLineParser.CommandLineParser;
import org.baltoaca.CommandLineParser.Executor;
import org.baltoaca.CommandLineParser.exceptions.ConsoleNotFoundException;
import org.baltoaca.CommandLineParser.exceptions.ExecutorNotFoundException;



public class Launcher {

	public static void main(String[] args) throws ConsoleNotFoundException, ExecutorNotFoundException {
		CommandLineParser.instance().setExecutor(new Executor() {
			
			@Override
			public String executeAndGenerateResponse(String[] commandElements) {
				return null;
			}
		});
		CommandLineParser.instance().run();
	}

}
