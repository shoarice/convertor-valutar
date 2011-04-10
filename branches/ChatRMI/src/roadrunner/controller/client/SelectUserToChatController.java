package roadrunner.controller.client;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JList;

import roadrunner.controller.Controller;
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
				//DOUBLE-CLICK
				if(e.getClickCount() == 2){
					new ChatWithUserController(component, usersList.getSelectedValue(), localUsername);
				}
			}
			
		});
	}
	
	
}
