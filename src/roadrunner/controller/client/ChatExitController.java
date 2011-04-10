package roadrunner.controller.client;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import roadrunner.controller.Controller;
import roadrunner.gui.ChatFrame;
import roadrunner.remote.ComponentImplementation;

public class ChatExitController extends Controller {
	private final ComponentImplementation component;
	private final ChatFrame frame;
	
	public ChatExitController(ComponentImplementation component, ChatFrame frame) {
		super();
		this.component = component;
		this.frame = frame;
		
		setUpActionOnExit();
	}
	private void setUpActionOnExit() {
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				component.removeFrame(frame);
			}
			
		});
	}
	
	
}
