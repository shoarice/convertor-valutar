package roadrunner.gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

//VS4E -- DO NOT REMOVE THIS LINE!
public class ClientFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel labelWelcome;
	private JLabel labelUsername;
	private JLabel labelStatus;
	private JComboBox comboBoxStatus;
	private JList listOnlineUsers;
	private JScrollPane jScrollPane0;
	private JButton buttonLogout;
	private JLabel labelLogo;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";
	public ClientFrame() {
		initComponents();
	}
	
	public static void showFrame(final ClientFrame frame){
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				frame.setTitle("ClientFrame");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJScrollPane0(), new Constraints(new Leading(20, 220, 10, 10), new Leading(79, 326, 10, 10)));
		add(getLabelWelcome(), new Constraints(new Leading(27, 6, 6), new Leading(12, 6, 6)));
		add(getLabelUsername(), new Constraints(new Leading(94, 143, 6, 6), new Leading(12, 6, 6)));
		add(getLabelStatus(), new Constraints(new Leading(27, 59, 6, 6), new Leading(45, 24, 6, 6)));
		add(getButtonLogout(), new Constraints(new Leading(20, 100, 6, 6), new Leading(423, 63, 6, 6)));
		add(getLabelLogo(), new Constraints(new Leading(136, 101, 6, 6), new Leading(426, 57, 6, 6)));
		add(getComboBoxStatus(), new Constraints(new Leading(81, 156, 10, 10), new Leading(45, 6, 6)));
		setSize(260, 513);
	}

	private JLabel getLabelLogo() {
		if (labelLogo == null) {
			labelLogo = new JLabel();
			labelLogo.setIcon(new ImageIcon("res/Logo2.jpg"));
		}
		return labelLogo;
	}

	private JButton getButtonLogout() {
		if (buttonLogout == null) {
			buttonLogout = new JButton();
			buttonLogout.setText("Logout");
		}
		return buttonLogout;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getListOnlineUsers());
		}
		return jScrollPane0;
	}

	public JList getListOnlineUsers() {
		if (listOnlineUsers == null) {
			listOnlineUsers = new JList();
			listOnlineUsers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
/*			DefaultListModel listModel = new DefaultListModel();
			listModel.addElement("item0");
			listModel.addElement("item1");
			listModel.addElement("item2");
			listModel.addElement("item3");
			listOnlineUsers.setModel(listModel);*/
		}
		return listOnlineUsers;
	}

	public JComboBox getComboBoxStatus() {
		if (comboBoxStatus == null) {
			comboBoxStatus = new JComboBox();
			//comboBoxStatus.setModel(new DefaultComboBoxModel(new Object[] { "item0", "item1", "item2", "item3" }));
		}
		return comboBoxStatus;
	}

	private JLabel getLabelStatus() {
		if (labelStatus == null) {
			labelStatus = new JLabel();
			labelStatus.setText("Status:");
		}
		return labelStatus;
	}

	public JLabel getLabelUsername() {
		if (labelUsername == null) {
			labelUsername = new JLabel();
			labelUsername.setText("user");
		}
		return labelUsername;
	}

	private JLabel getLabelWelcome() {
		if (labelWelcome == null) {
			labelWelcome = new JLabel();
			labelWelcome.setText("Welcome");
		}
		return labelWelcome;
	}

	private static void installLnF() {
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
				ClientFrame frame = new ClientFrame();
				frame.setDefaultCloseOperation(ClientFrame.EXIT_ON_CLOSE);
				frame.setTitle("RoadRunner 1.0");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
