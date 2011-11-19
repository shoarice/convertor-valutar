package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
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
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome to");
		lblWelcome.setBounds(101, 14, 73, 16);
		frmLogin.getContentPane().add(lblWelcome);
		
		JLabel lblRoadrunnerNewscenter = new JLabel("RoadRunner NewsCenter");
		lblRoadrunnerNewscenter.setBounds(50, 47, 178, 17);
		lblRoadrunnerNewscenter.setForeground(new Color(123, 104, 238));
		lblRoadrunnerNewscenter.setFont(new Font("Lucida Grande", Font.BOLD, 14));
		frmLogin.getContentPane().add(lblRoadrunnerNewscenter);
		
		JLabel lblWhatDoYou = new JLabel("What do you want to do ?");
		lblWhatDoYou.setBounds(59, 87, 158, 16);
		lblWhatDoYou.setHorizontalAlignment(SwingConstants.CENTER);
		frmLogin.getContentPane().add(lblWhatDoYou);
		
		JButton btnReadButton = new JButton("Read");
		btnReadButton.setBounds(59, 118, 158, 29);
		frmLogin.getContentPane().add(btnReadButton);
		
		JButton btnWriteButton = new JButton("Write");
		btnWriteButton.setBounds(59, 159, 158, 29);
		frmLogin.getContentPane().add(btnWriteButton);
	}

}
