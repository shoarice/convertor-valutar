package roadrunner.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import roadrunner.remote.ComponentImplementation;

public class ComponentAddUser extends Controller
{
	private JButton button;
	private ComponentImplementation impl;
	
	public ComponentAddUser(ComponentImplementation impl,JButton button)
	{
		this.button=button;
		this.impl=impl;
		setButtonListener();
	}
	
	private void setButtonListener()
	{
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				impl.addLocalUser("random"+Math.random());
			}
		});
	}
}
