import org.baltoaca.CommandLineParser.CommandLineParser;

import exceptions.ConsoleNotFoundException;


public class Main {

	public static void main(String[] args) throws ConsoleNotFoundException {
		CommandLineParser.instance().run();
	}

}
