package org.baltoaca.conv_valut.gui.designer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;

import org.baltoaca.conv_valut.mvc.ConvValutarModel;

public class MainFrame {

	private JFrame frame;
	private JLabel lblData;
	private JList lsTo;
	private JList lsFrom;
	private JTextField txtSum;
	private JTextField txtRate;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
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
		frame.setBounds(100, 100, 939, 392);
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
		
		lblData = new JLabel("14 August 2011");
		panel.add(lblData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "Schimb\u0103", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		scrollPane.setBounds(25, 89, 228, 184);
		frame.getContentPane().add(scrollPane);
		
		lsFrom = new JList();
		scrollPane.setViewportView(lsFrom);
		lsFrom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBorder(new TitledBorder(null, "\u00EEn", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		scrollPane_1.setBounds(267, 90, 228, 184);
		frame.getContentPane().add(scrollPane_1);
		
		lsTo = new JList();
		scrollPane_1.setViewportView(lsTo);
		lsTo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		txtSum = new JTextField();
		txtSum.setText("1");
		txtSum.setHorizontalAlignment(SwingConstants.CENTER);
		txtSum.setBounds(719, 59, 122, 28);
		frame.getContentPane().add(txtSum);
		txtSum.setColumns(10);
		
		txtRate = new JTextField();
		txtRate.setText("0");
		txtRate.setHorizontalAlignment(SwingConstants.CENTER);
		txtRate.setBounds(719, 105, 122, 28);
		frame.getContentPane().add(txtRate);
		txtRate.setColumns(10);
		
		JLabel lblFromCurrency = new JLabel("EUR");
		lblFromCurrency.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFromCurrency.setBounds(853, 65, 55, 16);
		frame.getContentPane().add(lblFromCurrency);
		
		JLabel lblSum = new JLabel("Sum\u0103");
		lblSum.setLabelFor(txtSum);
		lblSum.setBounds(637, 65, 55, 16);
		frame.getContentPane().add(lblSum);
		
		JLabel lblRata1 = new JLabel("Rat\u0103 de conversie");
		lblRata1.setLabelFor(txtRate);
		lblRata1.setBounds(579, 101, 112, 16);
		frame.getContentPane().add(lblRata1);
		
		JLabel lblRata2 = new JLabel("proprie");
		lblRata2.setLabelFor(txtRate);
		lblRata2.setBounds(636, 118, 55, 16);
		frame.getContentPane().add(lblRata2);
		
		JButton btnReverse = new JButton("Inverseaz\u0103");
		btnReverse.setMnemonic(KeyEvent.VK_S);
		btnReverse.setBounds(220, 285, 90, 28);
		frame.getContentPane().add(btnReverse);
		
		JLabel lblTva = new JLabel("tva");
		lblTva.setHorizontalAlignment(SwingConstants.CENTER);
		lblTva.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblTva.setBounds(723, 222, 105, 16);
		frame.getContentPane().add(lblTva);
		
		JLabel lblResultPlusTva = new JLabel("rez + tva");
		lblResultPlusTva.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblResultPlusTva.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultPlusTva.setBounds(723, 252, 105, 16);
		frame.getContentPane().add(lblResultPlusTva);
		
		JLabel lblResult = new JLabel("rez");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblResult.setBounds(723, 298, 105, 16);
		frame.getContentPane().add(lblResult);
		
		JLabel lblTvaDescriptor = new JLabel("TVA (XX%)");
		lblTvaDescriptor.setLabelFor(lblTva);
		lblTvaDescriptor.setText("TVA ("
				+ new Integer((int) (ConvValutarModel.VAT * 100)) + "%)");
		lblTvaDescriptor.setBounds(625, 222, 67, 16);
		frame.getContentPane().add(lblTvaDescriptor);
		
		JLabel lblResultPlusTvaDescriptor = new JLabel("Rezultat + TVA");
		lblResultPlusTvaDescriptor.setLabelFor(lblResultPlusTva);
		lblResultPlusTvaDescriptor.setBounds(608, 252, 84, 16);
		frame.getContentPane().add(lblResultPlusTvaDescriptor);
		
		JLabel lblResultDescriptor = new JLabel("Rezultat");
		lblResultDescriptor.setForeground(Color.RED);
		lblResultDescriptor.setOpaque(true);
		lblResultDescriptor.setLabelFor(lblResult);
		lblResultDescriptor.setBounds(637, 298, 55, 16);
		frame.getContentPane().add(lblResultDescriptor);
		
		JLabel lblToCurrency = new JLabel("LEI");
		lblToCurrency.setBounds(853, 298, 55, 16);
		frame.getContentPane().add(lblToCurrency);
	}
}
