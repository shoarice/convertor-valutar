package roadrunner.controller.client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextArea;

import roadrunner.controller.Controller;

public class ChatSendController extends Controller {

	private final JTextArea sendTextArea;
	private final JTextArea chatTextArea;
	private final String localUsername;
	private final JButton sendButton;

	public ChatSendController(JTextArea sendTextArea, JTextArea chatTextArea,
			String localUsername, JButton sendButton) {
		super();
		this.sendTextArea = sendTextArea;
		this.chatTextArea = chatTextArea;
		this.localUsername = localUsername;
		this.sendButton = sendButton;
		
		setUpAction();
	}

	//TODO trimite mesajul pe RMI
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
				}
				
				sendTextArea.setText("");
				sendTextArea.requestFocus();
			}
		});
	}
	
	
	
}
