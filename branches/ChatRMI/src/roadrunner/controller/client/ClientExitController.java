package roadrunner.controller.client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import roadrunner.controller.Controller;
import roadrunner.gui.ClientFrame;
import roadrunner.remote.ComponentImplementation;

public class ClientExitController extends Controller {
	private final ClientFrame frame;
	private final String username;
	private final ComponentImplementation component;
	
	public ClientExitController(ClientFrame frame, String username, ComponentImplementation component) {
		super();
		this.frame = frame;
		this.username = username;
		this.component = component;
		
		setUpActionOnClose();
	}

	private void setUpActionOnClose() {
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				component.removeLocalUser(username);
			}
			
		});
	}
	
	
}
