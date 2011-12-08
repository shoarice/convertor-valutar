package gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

public class StireGui {

	private JFrame frame;
	private JTextArea textArea;
	private JLabel lblTitlu;
	private JLabel lblAutor;
	private JScrollPane scrollPane;
	private JLabel lblSource;
	private JLabel lblSursa;
	private JLabel lblCreated;
	private JLabel lblCreata;
	private JLabel lblModified;
	private JLabel lblModificata;
	private JButton btnClose;

	public JFrame getFrame() {
		return frame;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public JLabel getLblTitlu() {
		return lblTitlu;
	}

	public JLabel getLblAutor() {
		return lblAutor;
	}

	public JScrollPane getScrollPane() {
		return scrollPane;
	}

	public JLabel getLblSource() {
		return lblSource;
	}

	public JLabel getLblSursa() {
		return lblSursa;
	}

	public JLabel getLblCreated() {
		return lblCreated;
	}

	public JLabel getLblCreata() {
		return lblCreata;
	}

	public JLabel getLblModified() {
		return lblModified;
	}

	public JLabel getLblModificata() {
		return lblModificata;
	}

	public JButton getBtnClose() {
		return btnClose;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					StireGui window = new StireGui();
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
	public StireGui() {
		initialize();
	}
	
	public void show(){
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 522, 470);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 70, 458, 267);
		frame.getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		lblTitlu = new JLabel("titlu");
		lblTitlu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitlu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitlu.setBounds(10, 11, 229, 27);
		frame.getContentPane().add(lblTitlu);
		
		lblAutor = new JLabel("autor");
		lblAutor.setBounds(246, 45, 102, 14);
		frame.getContentPane().add(lblAutor);
		
		lblSource = new JLabel("Source:");
		lblSource.setBounds(32, 352, 46, 14);
		frame.getContentPane().add(lblSource);
		
		lblSursa = new JLabel("sursa");
		lblSursa.setBounds(88, 352, 114, 14);
		frame.getContentPane().add(lblSursa);
		
		lblCreated = new JLabel("Created:");
		lblCreated.setBounds(32, 377, 46, 14);
		frame.getContentPane().add(lblCreated);
		
		lblCreata = new JLabel("creata");
		lblCreata.setBounds(88, 377, 102, 14);
		frame.getContentPane().add(lblCreata);
		
		lblModified = new JLabel("Modified:");
		lblModified.setBounds(32, 402, 46, 14);
		frame.getContentPane().add(lblModified);
		
		lblModificata = new JLabel("modificata");
		lblModificata.setBounds(88, 402, 102, 14);
		frame.getContentPane().add(lblModificata);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(354, 362, 102, 44);
		frame.getContentPane().add(btnClose);
	}
}
