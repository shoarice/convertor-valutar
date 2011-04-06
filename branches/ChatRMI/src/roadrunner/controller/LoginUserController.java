package roadrunner.controller;

import javax.swing.JOptionPane;

import com.sun.istack.internal.Pool.Impl;

import roadrunner.model.Network;
import roadrunner.remote.ComponentImplementation;

public class LoginUserController extends Controller {
	
	private ComponentImplementation component;
	
	public LoginUserController(ComponentImplementation component){
		this.component = component;
		
		loginUser();
	}

	private void loginUser() {
		String username = JOptionPane.showInputDialog("Introduceti numele de utilizator dorit: ");
		username = username.trim();
		
		if (Network.instance().isUserPresent(username))
			JOptionPane.showMessageDialog(null,
					"Numele de utilizator este luat", "Oooops",
					JOptionPane.INFORMATION_MESSAGE);
		else
			component.addLocalUser(username);
	}

}
