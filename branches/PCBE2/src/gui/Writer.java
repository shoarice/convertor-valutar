package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Writer {

	private JFrame frmWritersCenter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Writer window = new Writer();
					window.frmWritersCenter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Writer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWritersCenter = new JFrame();
		frmWritersCenter.setTitle("Writer's Center");
		frmWritersCenter.setResizable(false);
		frmWritersCenter.setBounds(100, 100, 714, 513);
		frmWritersCenter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWritersCenter.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(477, 20, 186, 403);
		frmWritersCenter.getContentPane().add(scrollPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 69, 409, 305);
		frmWritersCenter.getContentPane().add(scrollPane_1);
	}
}
