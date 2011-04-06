package roadrunner;

import roadrunner.controller.ComponentAddUser;
import roadrunner.gui.ComponentFrame;
import roadrunner.remote.ComponentImplementation;
import roadrunner.view.ComponentUserList;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ComponentImplementation compimpl;
		ComponentAddUser compaddusr;
		compimpl = ComponentImplementation.start(args);
		ComponentFrame frame=initGUI();
		ComponentUserList compusrlist = new ComponentUserList(compimpl, frame.getListLocalUsers());
		
		compaddusr = new ComponentAddUser(compimpl, frame.getButtonApasa());
	}

	private static ComponentFrame initGUI() {
		ComponentFrame frame = new ComponentFrame();
		frame.setDefaultCloseOperation(ComponentFrame.EXIT_ON_CLOSE);
		frame.setTitle("ComponentFrame");
		frame.getContentPane().setPreferredSize(frame.getSize());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		return frame;
	}

}
