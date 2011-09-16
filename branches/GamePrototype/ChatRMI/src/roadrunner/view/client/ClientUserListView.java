package roadrunner.view.client;

import java.util.Observable;

import javax.swing.SwingUtilities;

import roadrunner.gui.ClientFrame;
import roadrunner.model.Model;
import roadrunner.model.Network;
import roadrunner.view.View;

public class ClientUserListView extends View {

	
	private final ClientFrame frame;

	public ClientUserListView(Model model, ClientFrame frame) {
		super(model);
		this.frame = frame;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				frame.getListOnlineUsers().setListData(Network.instance().getAllUsers());				
			}
		});
	}

}
