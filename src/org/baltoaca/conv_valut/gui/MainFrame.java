package org.baltoaca.conv_valut.gui;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

//VS4E -- DO NOT REMOVE THIS LINE!
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JLabel jLabel0;
	private JLabel jLabel1;
	private JList jList0;
	private JScrollPane jScrollPane0;
	private JList jList1;
	private JScrollPane jScrollPane1;
	private JMenuItem jMenuItem0;
	private JMenu jMenu0;
	private JMenu jMenu1;
	private JMenuItem jMenuItem2;
	private JMenuItem jMenuItem3;
	private JMenu jMenu2;
	private JMenuBar jMenuBar0;
	private JButton jButton0;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel2;
	private JTextField jTextField0;
	private JTextField jTextField1;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JLabel jLabel10;
	private JLabel jLabel12;
	private JLabel jLabel13;
	private JLabel jLabel14;
	private JLabel jLabel11;
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

	public MainFrame() {
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJLabel0(), new Constraints(new Leading(113, 10, 10), new Leading(20, 10, 10)));
		add(getJLabel1(), new Constraints(new Leading(104, 12, 12), new Leading(39, 10, 10)));
		add(getJButton0(), new Constraints(new Leading(106, 100, 10, 10), new Leading(259, 12, 12)));
		add(getJScrollPane0(), new Constraints(new Leading(41, 100, 10, 10), new Leading(85, 155, 10, 10)));
		add(getJScrollPane1(), new Constraints(new Leading(181, 100, 10, 10), new Leading(87, 153, 12, 12)));
		add(getJLabel3(), new Constraints(new Leading(423, 12, 12), new Leading(67, 10, 10)));
		add(getJLabel4(), new Constraints(new Leading(483, 12, 12), new Leading(89, 12, 12)));
		add(getJLabel2(), new Constraints(new Leading(489, 12, 12), new Leading(33, 12, 12)));
		add(getJTextField0(), new Constraints(new Leading(552, 112, 10, 10), new Leading(27, 12, 12)));
		add(getJTextField1(), new Constraints(new Leading(552, 112, 12, 12), new Leading(73, 12, 12)));
		add(getJLabel5(), new Constraints(new Leading(676, 12, 12), new Leading(33, 12, 12)));
		add(getJLabel6(), new Constraints(new Leading(465, 12, 12), new Leading(178, 10, 10)));
		add(getJLabel7(), new Constraints(new Leading(444, 12, 12), new Leading(200, 12, 12)));
		add(getJLabel8(), new Constraints(new Leading(478, 12, 12), new Leading(242, 10, 10)));
		add(getJLabel9(), new Constraints(new Leading(558, 116, 12, 12), new Leading(178, 12, 12)));
		add(getJLabel10(), new Constraints(new Leading(558, 116, 12, 12), new Leading(200, 12, 12)));
		add(getJLabel12(), new Constraints(new Leading(689, 10, 10), new Leading(178, 12, 12)));
		add(getJLabel13(), new Constraints(new Leading(689, 12, 12), new Leading(202, 12, 12)));
		add(getJLabel14(), new Constraints(new Leading(689, 12, 12), new Leading(242, 12, 12)));
		add(getJLabel11(), new Constraints(new Leading(558, 116, 12, 12), new Leading(240, 12, 12)));
		setJMenuBar(getJMenuBar0());
		setSize(754, 328);
	}

	private JLabel getJLabel11() {
		if (jLabel11 == null) {
			jLabel11 = new JLabel();
			jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel11.setText("3524,57");
			jLabel11.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, null, null));
		}
		return jLabel11;
	}

	private JLabel getJLabel14() {
		if (jLabel14 == null) {
			jLabel14 = new JLabel();
			jLabel14.setText("LEI");
		}
		return jLabel14;
	}

	private JLabel getJLabel13() {
		if (jLabel13 == null) {
			jLabel13 = new JLabel();
			jLabel13.setText("LEI");
		}
		return jLabel13;
	}

	private JLabel getJLabel12() {
		if (jLabel12 == null) {
			jLabel12 = new JLabel();
			jLabel12.setText("LEI");
		}
		return jLabel12;
	}

	private JLabel getJLabel10() {
		if (jLabel10 == null) {
			jLabel10 = new JLabel();
			jLabel10.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel10.setText("jLabel10");
			jLabel10.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, null, null));
		}
		return jLabel10;
	}

	private JLabel getJLabel9() {
		if (jLabel9 == null) {
			jLabel9 = new JLabel();
			jLabel9.setHorizontalAlignment(SwingConstants.CENTER);
			jLabel9.setText("jLabel9");
			jLabel9.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, null, null));
		}
		return jLabel9;
	}

	private JLabel getJLabel8() {
		if (jLabel8 == null) {
			jLabel8 = new JLabel();
			jLabel8.setForeground(Color.red);
			jLabel8.setText("Rezultat");
		}
		return jLabel8;
	}

	private JLabel getJLabel7() {
		if (jLabel7 == null) {
			jLabel7 = new JLabel();
			jLabel7.setText("Rezultat + TVA");
		}
		return jLabel7;
	}

	private JLabel getJLabel6() {
		if (jLabel6 == null) {
			jLabel6 = new JLabel();
			jLabel6.setText("TVA (24%)");
		}
		return jLabel6;
	}

	private JLabel getJLabel5() {
		if (jLabel5 == null) {
			jLabel5 = new JLabel();
			jLabel5.setText("EUR");
		}
		return jLabel5;
	}

	private JTextField getJTextField1() {
		if (jTextField1 == null) {
			jTextField1 = new JTextField();
			jTextField1.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField1.setText("jTextField1");
		}
		return jTextField1;
	}

	private JTextField getJTextField0() {
		if (jTextField0 == null) {
			jTextField0 = new JTextField();
			jTextField0.setHorizontalAlignment(SwingConstants.CENTER);
			jTextField0.setText("jTextField0");
		}
		return jTextField0;
	}

	private JLabel getJLabel2() {
		if (jLabel2 == null) {
			jLabel2 = new JLabel();
			jLabel2.setText("Sumã");
		}
		return jLabel2;
	}

	private JLabel getJLabel4() {
		if (jLabel4 == null) {
			jLabel4 = new JLabel();
			jLabel4.setText("proprie");
		}
		return jLabel4;
	}

	private JLabel getJLabel3() {
		if (jLabel3 == null) {
			jLabel3 = new JLabel();
			jLabel3.setText("Ratã de conversie");
		}
		return jLabel3;
	}

	private JButton getJButton0() {
		if (jButton0 == null) {
			jButton0 = new JButton();
			jButton0.setText("Inverseazã");
		}
		return jButton0;
	}

	private JMenuBar getJMenuBar0() {
		if (jMenuBar0 == null) {
			jMenuBar0 = new JMenuBar();
			jMenuBar0.add(getJMenu0());
			jMenuBar0.add(getJMenu1());
			jMenuBar0.add(getJMenu2());
		}
		return jMenuBar0;
	}

	private JMenu getJMenu2() {
		if (jMenu2 == null) {
			jMenu2 = new JMenu();
			jMenu2.setText("Ajutor");
			jMenu2.add(getJMenuItem2());
			jMenu2.add(getJMenuItem3());
		}
		return jMenu2;
	}

	private JMenuItem getJMenuItem3() {
		if (jMenuItem3 == null) {
			jMenuItem3 = new JMenuItem();
			jMenuItem3.setText("Despre");
		}
		return jMenuItem3;
	}

	private JMenuItem getJMenuItem2() {
		if (jMenuItem2 == null) {
			jMenuItem2 = new JMenuItem();
			jMenuItem2.setText("Ghid utilizare");
		}
		return jMenuItem2;
	}

	private JMenu getJMenu1() {
		if (jMenu1 == null) {
			jMenu1 = new JMenu();
			jMenu1.setText("Opþiuni");
		}
		return jMenu1;
	}

	private JMenu getJMenu0() {
		if (jMenu0 == null) {
			jMenu0 = new JMenu();
			jMenu0.setText("File");
			jMenu0.add(getJMenuItem0());
		}
		return jMenu0;
	}

	private JMenuItem getJMenuItem0() {
		if (jMenuItem0 == null) {
			jMenuItem0 = new JMenuItem();
			jMenuItem0.setText("Ieºire");
		}
		return jMenuItem0;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setViewportView(getJList1());
		}
		return jScrollPane1;
	}

	private JList getJList1() {
		if (jList1 == null) {
			jList1 = new JList();
			jList1.setBorder(BorderFactory.createTitledBorder(null, "în", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, new Font("SansSerif", Font.BOLD, 12),
					new Color(59, 59, 59)));
			jList1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			DefaultListModel listModel = new DefaultListModel();
			listModel.addElement("item0");
			listModel.addElement("item1");
			listModel.addElement("item2");
			listModel.addElement("item3");
			jList1.setModel(listModel);
		}
		return jList1;
	}

	private JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setViewportView(getJList0());
		}
		return jScrollPane0;
	}

	private JList getJList0() {
		if (jList0 == null) {
			jList0 = new JList();
			jList0.setBorder(BorderFactory.createTitledBorder(null, "Schimbã", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, new Font("SansSerif", Font.BOLD, 12),
					new Color(59, 59, 59)));
			jList0.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			DefaultListModel listModel = new DefaultListModel();
			listModel.addElement("item0");
			listModel.addElement("item1");
			listModel.addElement("item2");
			listModel.addElement("item3");
			jList0.setModel(listModel);
		}
		return jList0;
	}

	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("14 August 2010");
			jLabel1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED, null, null));
		}
		return jLabel1;
	}

	private JLabel getJLabel0() {
		if (jLabel0 == null) {
			jLabel0 = new JLabel();
			jLabel0.setText("Data cursului");
		}
		return jLabel0;
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
				MainFrame frame = new MainFrame();
				frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
				frame.setTitle("MainFrame");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

}
