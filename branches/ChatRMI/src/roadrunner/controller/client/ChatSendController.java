package roadrunner.controller.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JTextArea;

import roadrunner.controller.Controller;
import roadrunner.gui.ChatFrame;
import roadrunner.model.Network;
import roadrunner.remote.Component;

public class ChatSendController extends Controller {

	private final JTextArea sendTextArea;
	private final JTextArea chatTextArea;
	private final String localUsername;
	private final String remoteUsername;
	private final JButton sendButton;

	public ChatSendController(ChatFrame chatFrame, String localUsername, String remoteUsername) {
		super();
		
		sendTextArea = chatFrame.getTextAreaSend();
		chatTextArea = chatFrame.getTextAreaChat();
		sendButton = chatFrame.getButtonSend();
		this.remoteUsername = remoteUsername;
		this.localUsername = localUsername;
		
		setUpAction();
	}

	private void setUpAction() {
		sendButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String msg = sendTextArea.getText().trim();
				
				if(msg.length()!=0){
					chatTextArea.append(localUsername);
					chatTextArea.append(": ");
					chatTextArea.append(msg);
					chatTextArea.append("\n");
				
				
					sendTextArea.setText("");
					sendTextArea.requestFocus();
					
					
					Component component = Network.instance().getComponentForUser(remoteUsername);
					if(component == null){
						actionIfRemoteUserIsNotAvailable();
					}else{
						try {
							if(false == component.sendMessage(localUsername, remoteUsername, msg))
								actionIfRemoteUserIsNotAvailable();
						} catch (RemoteException e) {
							e.printStackTrace();
							
						}
					}
				}
				
			}
			
			
		});
	}

	private void actionIfRemoteUserIsNotAvailable() {
		chatTextArea.append("\n\nThe user is not available\n");
	}
	
	
	
}
