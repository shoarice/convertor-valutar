import org.baltoaca.CommandLineParser.CommandLineParser;

import exceptions.ConsoleNotFoundException;
import exceptions.ExecutorNotFoundException;


public class Main {

	public static void main(String[] args) throws ConsoleNotFoundException, ExecutorNotFoundException {
		CommandLineParser.instance().run();
	}

}
