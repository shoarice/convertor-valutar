package roadrunner.controller.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import roadrunner.controller.Controller;
import roadrunner.gui.ClientFrame;
import roadrunner.model.Status;
import roadrunner.remote.ComponentImplementation;

public class SetStatusForUserController extends Controller {
	
	private final ClientFrame frame;
	private final String username;
	private final ComponentImplementation component;
	
	public SetStatusForUserController(ClientFrame frame, String username,
			ComponentImplementation component) {
		super();
		this.frame = frame;
		this.username = username;
		this.component = component;
		
		setAction();
	}

	private void setAction() {
		frame.getComboBoxStatus().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				component.setStatusForUser(username, (Status) frame.getComboBoxStatus().getSelectedItem());
			}
		});
	}
	
	
}
