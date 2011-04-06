package roadrunner.controller;

import javax.swing.JOptionPane;

import com.sun.istack.internal.Pool.Impl;

import roadrunner.remote.ComponentImplementation;

public class LoginUserController extends Controller {
	
	private ComponentImplementation component;
	
	public LoginUserController(ComponentImplementation component){
		this.component = component;
		
		loginUser();
	}

	private void loginUser() {
		String username = JOptionPane.showInputDialog("Introduceti numele de user dorit: ");
		username = username.trim();
		
		//TODO verifica daca userul exista sau nu in sistem
		
		component.addLocalUser(username);
	}

}
