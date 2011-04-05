package roadrunner;

import roadrunner.controller.ComponentUserList;
import roadrunner.gui.ComponentFrame;
import roadrunner.remote.ComponentImplementation;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ComponentImplementation compimpl;
		compimpl = ComponentImplementation.start(args);
		ComponentFrame frame=initGUI();
		ComponentUserList compusrlist = new ComponentUserList(compimpl, frame.getListLocalUsers());
		
		compimpl.addLocalUser("andrei");
		compimpl.addLocalUser("vlad");
		compimpl.addLocalUser("PinkyPrincess");
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
