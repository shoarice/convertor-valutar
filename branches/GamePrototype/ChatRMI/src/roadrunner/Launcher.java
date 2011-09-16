package roadrunner;

import roadrunner.controller.component.ComponentAddUserController;
import roadrunner.controller.component.ComponentExitController;
import roadrunner.gui.ComponentFrame;
import roadrunner.remote.ComponentImplementation;
import roadrunner.view.component.ComponentUserList;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ComponentImplementation component = ComponentImplementation.start(args);
		ComponentFrame frame=initGUI();
		
		new ComponentUserList(component, frame.getListLocalUsers());
		new ComponentAddUserController(component, frame.getButtonApasa());
		new ComponentExitController(frame, component);
	}

	private static ComponentFrame initGUI() {
		ComponentFrame frame = new ComponentFrame();
		frame.setDefaultCloseOperation(ComponentFrame.EXIT_ON_CLOSE);
		frame.setTitle("Local User List");
		frame.getContentPane().setPreferredSize(frame.getSize());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		return frame;
	}

}
