package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JEditorPane;
import javax.swing.JCheckBox;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Reader {

	private JFrame frmReader;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reader window = new Reader();
					window.frmReader.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Reader() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmReader = new JFrame();
		frmReader.setResizable(false);
		frmReader.setTitle("Reader's Center");
		frmReader.setBounds(100, 100, 713, 512);
		frmReader.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmReader.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose your category");
		lblNewLabel.setBounds(6, 21, 148, 16);
		frmReader.getContentPane().add(lblNewLabel);
		
		JCheckBox chckbxStocks = new JCheckBox("Stocks");
		chckbxStocks.setForeground(new Color(0, 0, 205));
		chckbxStocks.setBounds(26, 74, 128, 23);
		frmReader.getContentPane().add(chckbxStocks);
		
		JCheckBox chckbxEconomy = new JCheckBox("Economy");
		chckbxEconomy.setForeground(new Color(0, 0, 205));
		chckbxEconomy.setBounds(26, 99, 128, 23);
		frmReader.getContentPane().add(chckbxEconomy);
		
		JCheckBox chckbxBusiness = new JCheckBox("Business");
		chckbxBusiness.setForeground(new Color(0, 0, 205));
		chckbxBusiness.setBounds(26, 124, 128, 23);
		frmReader.getContentPane().add(chckbxBusiness);
		
		JCheckBox chckbxFinance = new JCheckBox("Finance");
		chckbxFinance.setForeground(new Color(0, 0, 205));
		chckbxFinance.setBounds(16, 49, 128, 23);
		frmReader.getContentPane().add(chckbxFinance);
		
		JCheckBox chckbxFootball = new JCheckBox("Football");
		chckbxFootball.setForeground(new Color(50, 205, 50));
		chckbxFootball.setBounds(26, 182, 128, 23);
		frmReader.getContentPane().add(chckbxFootball);
		
		JCheckBox chckbxTenis = new JCheckBox("Tenis");
		chckbxTenis.setForeground(new Color(50, 205, 50));
		chckbxTenis.setBounds(26, 207, 128, 23);
		frmReader.getContentPane().add(chckbxTenis);
		
		JCheckBox chckbxHockey = new JCheckBox("Hockey");
		chckbxHockey.setForeground(new Color(50, 205, 50));
		chckbxHockey.setBounds(26, 232, 128, 23);
		frmReader.getContentPane().add(chckbxHockey);
		
		JCheckBox chckbxSports = new JCheckBox("Sports");
		chckbxSports.setForeground(new Color(50, 205, 50));
		chckbxSports.setBounds(16, 157, 128, 23);
		frmReader.getContentPane().add(chckbxSports);
		
		JCheckBox chckbxBasketball = new JCheckBox("Basketball");
		chckbxBasketball.setForeground(new Color(50, 205, 50));
		chckbxBasketball.setBounds(26, 257, 128, 23);
		frmReader.getContentPane().add(chckbxBasketball);
		
		JCheckBox chckbxHealth = new JCheckBox("Health");
		chckbxHealth.setForeground(new Color(255, 0, 0));
		chckbxHealth.setBounds(26, 316, 128, 23);
		frmReader.getContentPane().add(chckbxHealth);
		
		JCheckBox chckbxDiet = new JCheckBox("Diet");
		chckbxDiet.setForeground(new Color(255, 0, 0));
		chckbxDiet.setBounds(26, 341, 128, 23);
		frmReader.getContentPane().add(chckbxDiet);
		
		JCheckBox chckbxFashion = new JCheckBox("Fashion");
		chckbxFashion.setForeground(new Color(255, 0, 0));
		chckbxFashion.setBounds(26, 366, 128, 23);
		frmReader.getContentPane().add(chckbxFashion);
		
		JCheckBox chckbxLifestyle = new JCheckBox("Lifestyle");
		chckbxLifestyle.setForeground(new Color(255, 0, 0));
		chckbxLifestyle.setBounds(16, 291, 128, 23);
		frmReader.getContentPane().add(chckbxLifestyle);
		
		JCheckBox chckbxPc = new JCheckBox("P&C");
		chckbxPc.setForeground(new Color(255, 0, 255));
		chckbxPc.setBounds(26, 426, 128, 23);
		frmReader.getContentPane().add(chckbxPc);
		
		JCheckBox chckbxCelebrities = new JCheckBox("Celebrities");
		chckbxCelebrities.setForeground(new Color(255, 0, 255));
		chckbxCelebrities.setBounds(26, 451, 128, 23);
		frmReader.getContentPane().add(chckbxCelebrities);
		
		JCheckBox chckbxMondane = new JCheckBox("Fashionable");
		chckbxMondane.setForeground(new Color(255, 0, 255));
		chckbxMondane.setBounds(16, 401, 128, 23);
		frmReader.getContentPane().add(chckbxMondane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(214, 49, 457, 315);
		frmReader.getContentPane().add(scrollPane);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(278, 400, 117, 29);
		frmReader.getContentPane().add(btnSubmit);
		
		JButton btnClose = new JButton("Close");
		btnClose.setBounds(508, 400, 117, 29);
		frmReader.getContentPane().add(btnClose);
		frmReader.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, chckbxFinance, chckbxStocks, chckbxEconomy, chckbxBusiness, chckbxSports, chckbxFootball, chckbxTenis, chckbxHockey, chckbxBasketball}));
	}
}
