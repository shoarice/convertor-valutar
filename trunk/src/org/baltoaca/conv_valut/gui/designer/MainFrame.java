package org.baltoaca.conv_valut.gui.designer;

import java.awt.EventQueue;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.Rectangle;
import java.awt.Color;

public class MainFrame {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame window = new MainFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 736, 348);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		JMenuItem mntmIesire = new JMenuItem("Iesire");
		mntmIesire.setMnemonic(KeyEvent.VK_I);
		mnFile.add(mntmIesire);
		
		JMenu mnOptiuni = new JMenu("Optiuni");
		mnOptiuni.setMnemonic(KeyEvent.VK_O);
		menuBar.add(mnOptiuni);
		
		JMenu mnAjutor = new JMenu("Ajutor");
		mnAjutor.setMnemonic(KeyEvent.VK_A);
		menuBar.add(mnAjutor);
		
		JMenuItem mntmGhidUtilizare = new JMenuItem("Ghid utilizare");
		mntmGhidUtilizare.setMnemonic(KeyEvent.VK_G);
		mnAjutor.add(mntmGhidUtilizare);
		
		JMenuItem mntmDespre = new JMenuItem("Despre");
		mntmDespre.setMnemonic(KeyEvent.VK_D);
		mnAjutor.add(mntmDespre);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Data cursului", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(208, 17, 116, 60);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblData = new JLabel("14 August 2011");
		panel.add(lblData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Schimba", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		scrollPane.setBounds(39, 101, 228, 184);
		frame.getContentPane().add(scrollPane);
		
		JList lsFrom = new JList();
		scrollPane.setViewportView(lsFrom);
		lsFrom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new TitledBorder(null, "in", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, null));
		scrollPane_1.setBounds(281, 102, 228, 184);
		frame.getContentPane().add(scrollPane_1);
		
		JList list = new JList();
		scrollPane_1.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}
}
