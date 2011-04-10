package roadrunner.controller.component;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import roadrunner.controller.Controller;
import roadrunner.remote.ComponentImplementation;

public class ComponentAddUserController extends Controller
{
	private JButton button;
	private ComponentImplementation impl;
	
	public ComponentAddUserController(ComponentImplementation impl,JButton button)
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
				new LoginUserController(impl);
			}
		});
	}
}
