package roadrunner.controller;

import javax.swing.JOptionPane;

import roadrunner.model.Network;
import roadrunner.remote.ComponentImplementation;

public class LoginUserController extends Controller {
	
	private final ComponentImplementation component;
	
	public LoginUserController(ComponentImplementation component){
		this.component = component;
		
		loginUser();
	}

	private void loginUser() {
		String username = JOptionPane.showInputDialog("Introduceti numele de utilizator dorit: ");
		if(username != null){
			username = username.trim();
			
			if (Network.instance().isUserPresent(username))
				JOptionPane.showMessageDialog(null,
						"Numele de utilizator este luat", "Oooops",
						JOptionPane.INFORMATION_MESSAGE);
			else{
				new StartClientFrameController(username, component);
			}
		}
	}

}
