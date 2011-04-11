package roadrunner.gui;

import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

//VS4E -- DO NOT REMOVE THIS LINE!
public class ChatFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JTextArea textAreaChat;
	private JScrollPane jScrollPane0;
	private JTextArea textAreaSend;
	private JScrollPane jScrollPane1;
	private JButton buttonSend;
	private JLabel labelLogo;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	public ChatFrame() {
		initComponents();
	}
	
	public static ChatFrame getFrame(final String title){
		final ChatFrame frame = new ChatFrame();
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.setDefaultCloseOperation(ChatFrame.DISPOSE_ON_CLOSE);
				frame.setTitle(title);
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.getRootPane().setDefaultButton(frame.getButtonSend());
			}
		});
		return frame;
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJScrollPane0(), new Constraints(new Leading(13, 536, 10, 10), new Leading(11, 191, 12, 12)));
		add(getButtonSend(), new Constraints(new Leading(467, 82, 6, 6), new Leading(208, 80, 6, 6)));
		add(getLabelLogo(), new Constraints(new Leading(13, 89, 6, 6), new Leading(210, 75, 6, 6)));
		add(getJScrollPane1(), new Constraints(new Leading(114, 341, 6, 6), new Leading(207, 80, 10, 10)));
		setSize(559, 299);
	}

	private JLabel getLabelLogo() {
		if (labelLogo == null) {
			labelLogo = new JLabel();
			labelLogo.setIcon(new ImageIcon("res/Logo3.jpg"));
		}
		return labelLogo;
	}

	public JTextArea getTextAreaChat() {
		if (textAreaChat == null) {
			textAreaChat = new JTextArea();
			textAreaChat.setLineWrap(true);
			textAreaChat.setWrapStyleWord(true);
			textAreaChat.setDoubleBuffered(true);
			textAreaChat.setAutoscrolls(true);
			textAreaChat.setEditable(false);
		}
		return textAreaChat;
	}

	public JTextArea getTextAreaSend() {
		if (textAreaSend == null) {
			textAreaSend = new JTextArea();
			textAreaSend.setLineWrap(true);
			textAreaSend.setWrapStyleWord(true);
			textAreaSend.setAutoscrolls(true);
		}
		return textAreaSend;
	}

	public JButton getButtonSend() {
		if (buttonSend == null) {
			buttonSend = new JButton();
			buttonSend.setText("Send");
			buttonSend.setMnemonic(KeyEvent.VK_ENTER);
		}
		return buttonSend;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getTextAreaSend());
		}
		return jScrollPane1;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getTextAreaChat());
		}
		return jScrollPane0;
	}

	public JTextArea getJTextArea0() {
		if (textAreaChat == null) {
			textAreaChat = new JTextArea();
			textAreaChat.setAutoscrolls(true);
		}
		return textAreaChat;
	}

	public static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class.
	 * Note: This class is only created so that you can easily preview the result at runtime.
	 * It is not expected to be managed by the designer.
	 * You can modify it as you like.
	 */
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ChatFrame frame = new ChatFrame();
				frame.setDefaultCloseOperation(ChatFrame.EXIT_ON_CLOSE);
				frame.setTitle("ChatFrame");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				frame.getRootPane().setDefaultButton(frame.getButtonSend());
			}
		});
	}

}
