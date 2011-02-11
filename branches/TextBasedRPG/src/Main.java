import org.baltoaca.CommandLineParser.CommandLineParser;
import org.baltoaca.CommandLineParser.Executor;

import exceptions.ConsoleNotFoundException;
import exceptions.ExecutorNotFoundException;


public class Main {

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
