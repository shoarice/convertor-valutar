package roadrunner.server;

import java.net.Socket;

public interface ClientHandler {
	void handleClient(Socket clientSocket);
}
