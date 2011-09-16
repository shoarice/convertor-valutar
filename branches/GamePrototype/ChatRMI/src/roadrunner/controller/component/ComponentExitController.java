package roadrunner.controller.component;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import roadrunner.controller.Controller;
import roadrunner.gui.ComponentFrame;
import roadrunner.remote.ComponentImplementation;

public class ComponentExitController extends Controller{
	
	private ComponentFrame frame;
	private ComponentImplementation component;
	
	public ComponentExitController(ComponentFrame frame, ComponentImplementation component) {
		super();
		this.frame = frame;
		this.component = component;
		
		setUpActionOnClose();
	}

	private void setUpActionOnClose() {
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				component.disconnect();
			}
			
		});
	}
	
	
	

	
}
