package roadrunner.controller.client;

import javax.swing.SwingUtilities;

import roadrunner.gui.ChatFrame;
import roadrunner.model.User;
import roadrunner.remote.ComponentImplementation;

public class ChatWithUserController {

	private final String remoteUsername;
	private final ComponentImplementation component;
	private final  String localUsername;
	
	public ChatWithUserController(ComponentImplementation component,
			Object selectedValue, String localUsername) {
		
		this.remoteUsername = ((User) selectedValue).getUsername();
		this.component = component;
		this.localUsername = localUsername;
		startChatFrame();
	}
	private void startChatFrame() {
		final ChatFrame chatFrame = component.getChatFrameOrCreate(localUsername,remoteUsername);
		
		new ChatExitController(component, chatFrame);
		new ChatSendController(chatFrame, localUsername, remoteUsername);
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				chatFrame.getTextAreaSend().requestFocus();
			}
		});
		
	}

}
