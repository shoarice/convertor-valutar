package roadrunner.controller.client;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingUtilities;

import roadrunner.controller.Controller;
import roadrunner.gui.ClientFrame;
import roadrunner.model.Network;
import roadrunner.model.Status;
import roadrunner.model.User;
import roadrunner.remote.ComponentImplementation;
import roadrunner.view.client.ClientUserListView;

public class StartClientFrameController extends Controller {

	private final ComponentImplementation component;
	private final User user;
	
	public StartClientFrameController(String username, ComponentImplementation component){
		this.component = component;
		user = new User(username);
		
		startFrame();
	}

	private void startFrame() {
		final ClientFrame frame = new ClientFrame();
		setUpFrame(frame);
		
		new SetStatusForUserController(frame,user.getUsername(),component);
		new ClientUserListView(Network.instance(), frame);
		new ClientExitController(frame,user.getUsername(), component);
		component.addLocalUser(user, frame);
		ClientFrame.showFrame(frame);
	}

	private void setUpFrame(final ClientFrame frame) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				frame.getLabelUsername().setText(user.getUsername());
				frame.getComboBoxStatus().setModel(new DefaultComboBoxModel(Status.values()));
				
			}
		});
	}
}
