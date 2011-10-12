package roadrunner;

import java.io.IOException;

import roadrunner.server.Server;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			new Server().startServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
