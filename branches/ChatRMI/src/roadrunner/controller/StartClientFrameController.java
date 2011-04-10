package roadrunner.controller;

import roadrunner.gui.ClientFrame;
import roadrunner.model.User;
import roadrunner.remote.ComponentImplementation;

public class StartClientFrameController extends Controller {

	private final ComponentImplementation component;
	private final User user;
	
	public StartClientFrameController(String username, ComponentImplementation component){
		this.component = component;
		user = new User(username);
		
		startFrame();
	}

	private void startFrame() {
		ClientFrame frame = new ClientFrame();
		new ClientExitController(frame,user.getUsername(), component);
		component.addLocalUser(user, frame);
		ClientFrame.showFrame(frame);
	}
}
