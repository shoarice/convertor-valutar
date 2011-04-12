package roadrunner.controller.client;

import javax.swing.SwingUtilities;

import roadrunner.gui.ChatFrame;
import roadrunner.remote.ComponentImplementation;

public class ChatWithUserController {

	private final String remoteUsername;
	private final ComponentImplementation component;
	private final  String localUsername;
	public ChatWithUserController(ComponentImplementation component,
			Object selectedValue, String localUsername) {
		
		this.remoteUsername = (String) selectedValue;
		this.component = component;
		this.localUsername = localUsername;
		startChatFrame();
	}
	private void startChatFrame() {
		final ChatFrame chatFrame = ChatFrame.getFrame(remoteUsername);
		component.addChatFrameForUser(localUsername,chatFrame);
		
		new ChatExitController(component, chatFrame);
		new ChatSendController(chatFrame.getTextAreaSend(), chatFrame.getTextAreaChat(), localUsername, chatFrame.getButtonSend());
		
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				chatFrame.getTextAreaSend().requestFocus();
			}
		});
		
	}

}
