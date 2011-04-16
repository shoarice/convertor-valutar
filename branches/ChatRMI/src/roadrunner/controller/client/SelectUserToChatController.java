package roadrunner.controller.client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;
import javax.swing.JOptionPane;

import roadrunner.controller.Controller;
import roadrunner.model.Network;
import roadrunner.model.Status;
import roadrunner.model.User;
import roadrunner.remote.ComponentImplementation;

public class SelectUserToChatController extends Controller {
	private final JList usersList;
	private final ComponentImplementation component;
	private final String localUsername;
	
	public SelectUserToChatController(JList usersList,
			String localUsername, ComponentImplementation component) {
		super();
		this.usersList = usersList;
		this.component = component;
		this.localUsername = localUsername;
		setUpAction();
	}

	private void setUpAction() {
		usersList.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
				User selectedUser = (User) usersList.getSelectedValue();
				if(selectedUser == null)
					return;
				if(Network.instance().getUser((selectedUser.getUsername())).getStatus() == Status.BUSY){
					JOptionPane.showMessageDialog(null, "The selected user is busy", "Ooops", JOptionPane.INFORMATION_MESSAGE);
				}else
					//DOUBLE-CLICK
					if(e.getClickCount() == 2){
						new ChatWithUserController(component, usersList.getSelectedValue(), localUsername);
					}
			}
			
		});
	}
	
	
}
