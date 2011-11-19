package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class Login {

	private JFrame frmLogin;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setTitle("Welcome");
		frmLogin.setBounds(100, 100, 274, 226);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{49, 158, 0};
		gridBagLayout.rowHeights = new int[]{45, 0, 0, 16, 0, 16, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmLogin.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblWelcome = new JLabel("Welcome to");
		GridBagConstraints gbc_lblWelcome = new GridBagConstraints();
		gbc_lblWelcome.anchor = GridBagConstraints.NORTH;
		gbc_lblWelcome.insets = new Insets(0, 0, 5, 0);
		gbc_lblWelcome.gridx = 1;
		gbc_lblWelcome.gridy = 1;
		frmLogin.getContentPane().add(lblWelcome, gbc_lblWelcome);
		
		JLabel lblRoadrunnerNewscenter = new JLabel("RoadRunner NewsCenter");
		lblRoadrunnerNewscenter.setForeground(new Color(123, 104, 238));
		lblRoadrunnerNewscenter.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		GridBagConstraints gbc_lblRoadrunnerNewscenter = new GridBagConstraints();
		gbc_lblRoadrunnerNewscenter.insets = new Insets(0, 0, 5, 0);
		gbc_lblRoadrunnerNewscenter.gridx = 1;
		gbc_lblRoadrunnerNewscenter.gridy = 2;
		frmLogin.getContentPane().add(lblRoadrunnerNewscenter, gbc_lblRoadrunnerNewscenter);
		
		JLabel lblWhatDoYou = new JLabel("What do you want to do ?");
		lblWhatDoYou.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblWhatDoYou = new GridBagConstraints();
		gbc_lblWhatDoYou.insets = new Insets(0, 0, 5, 0);
		gbc_lblWhatDoYou.gridx = 1;
		gbc_lblWhatDoYou.gridy = 4;
		frmLogin.getContentPane().add(lblWhatDoYou, gbc_lblWhatDoYou);
		
		JButton btnReadButton = new JButton("Read");
		GridBagConstraints gbc_btnReadButton = new GridBagConstraints();
		gbc_btnReadButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnReadButton.gridx = 1;
		gbc_btnReadButton.gridy = 6;
		frmLogin.getContentPane().add(btnReadButton, gbc_btnReadButton);
		
		JButton btnWriteButton = new JButton("Write");
		GridBagConstraints gbc_btnWriteButton = new GridBagConstraints();
		gbc_btnWriteButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnWriteButton.gridx = 1;
		gbc_btnWriteButton.gridy = 7;
		frmLogin.getContentPane().add(btnWriteButton, gbc_btnWriteButton);
	}

}
