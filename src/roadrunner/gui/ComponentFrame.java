package roadrunner.gui;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

//VS4E -- DO NOT REMOVE THIS LINE!
public class ComponentFrame extends JFrame
{

	private static final long serialVersionUID = 1L;
	private JButton buttonApasa;
	private JList listLocalUsers;
	private JScrollPane jScrollPane0;
	private JLabel jLabel0;
	private static final String PREFERRED_LOOK_AND_FEEL = "javax.swing.plaf.metal.MetalLookAndFeel";
	public ComponentFrame()
	{
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJScrollPane0(), new Constraints(new Leading(14, 167, 10, 10), new Leading(14, 220, 10, 10)));
		add(getJLabel0(), new Constraints(new Leading(18, 78, 6, 6), new Leading(242, 58, 6, 6)));
		add(getButtonApasa(), new Constraints(new Leading(102, 79, 6, 6), new Leading(238, 66, 6, 6)));
		setSize(193, 319);
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setIcon(new ImageIcon("res/Logo.jpg"));
		}
		return jLabel0;
	}

	private JScrollPane getJScrollPane0()
	{
		if (jScrollPane0 == null)
		{
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getListLocalUsers());
		}
		return jScrollPane0;
	}

	public JList getListLocalUsers()
	{
		if (listLocalUsers == null)
		{
			listLocalUsers = new JList();
			DefaultListModel listModel = new DefaultListModel();
			listLocalUsers.setModel(listModel);

		}
		return listLocalUsers;
	}

	public JButton getButtonApasa()
	{
		if (buttonApasa == null)
		{
			buttonApasa = new JButton();
			buttonApasa.setText("Apasa");
		}
		return buttonApasa;
	}

	private static void installLnF()
	{
		try
		{
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e)
		{
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class. Note: This class is only created so that you can
	 * easily preview the result at runtime. It is not expected to be managed by
	 * the designer. You can modify it as you like.
	 */
	public static void main(String[] args)
	{
		installLnF();
		SwingUtilities.invokeLater(new Runnable()
		{
			@Override
			public void run()
			{
				ComponentFrame frame = new ComponentFrame();
				frame.setDefaultCloseOperation(ComponentFrame.EXIT_ON_CLOSE);
				frame.setTitle("Local User List");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}