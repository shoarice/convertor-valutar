package roadrunner.gui;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;
import org.dyno.visual.swing.layouts.Trailing;

//VS4E -- DO NOT REMOVE THIS LINE!
public class ClientFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel labelWelcome;
	private JLabel labelUsername;
	private JLabel labelStatus;
	private JComboBox comboBoxStatus;
	private JList listOnlineUsers;
	private JScrollPane jScrollPane0;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
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
		add(getLabelWelcome(), new Constraints(new Leading(7, 10, 10), new Leading(9, 10, 10)));
		add(getLabelUsername(), new Constraints(new Leading(71, 12, 12), new Leading(9, 12, 12)));
		add(getLabelStatus(), new Constraints(new Trailing(107, 108, 108), new Leading(9, 12, 12)));
		add(getComboBoxStatus(), new Constraints(new Leading(154, 86, 10, 10), new Leading(4, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Leading(20, 206, 10, 10), new Leading(39, 186, 10, 10)));
		setSize(253, 240);
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
				frame.setTitle("ClientFrame");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
