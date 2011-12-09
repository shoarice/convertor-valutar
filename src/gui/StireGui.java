package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import model.Stire;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					StireGui window = new StireGui(new Stire());
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
	public StireGui(Stire s) {
		initialize();
		textArea.setText(s.getStire());
		lblTitlu.setText(s.getTitlu());
		lblAutor.setText(s.getAutor());
		lblCreata.setText(s.getDataCreat());
		lblModificata.setText(s.getDataModificat());
		lblSursa.setText(s.getSursa());
		
		JLabel lblTitlu_1 = new JLabel("Titlu: ");
		lblTitlu_1.setBounds(33, 17, 61, 16);
		frame.getContentPane().add(lblTitlu_1);
		
		JLabel lblAutor_1 = new JLabel("Autor:");
		lblAutor_1.setBounds(33, 42, 61, 16);
		frame.getContentPane().add(lblAutor_1);
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
		lblTitlu.setBounds(119, 11, 229, 27);
		frame.getContentPane().add(lblTitlu);
		
		lblAutor = new JLabel("autor");
		lblAutor.setBounds(119, 43, 102, 14);
		frame.getContentPane().add(lblAutor);
		
		lblSource = new JLabel("Source:");
		lblSource.setBounds(32, 352, 46, 14);
		frame.getContentPane().add(lblSource);
		
		lblSursa = new JLabel("sursa");
		lblSursa.setBounds(106, 352, 114, 14);
		frame.getContentPane().add(lblSursa);
		
		lblCreated = new JLabel("Created:");
		lblCreated.setBounds(32, 377, 62, 14);
		frame.getContentPane().add(lblCreated);
		
		lblCreata = new JLabel("creata");
		lblCreata.setBounds(106, 378, 150, 14);
		frame.getContentPane().add(lblCreata);
		
		lblModified = new JLabel("Modified:");
		lblModified.setBounds(32, 402, 62, 14);
		frame.getContentPane().add(lblModified);
		
		lblModificata = new JLabel("modificata");
		lblModificata.setBounds(106, 402, 150, 14);
		frame.getContentPane().add(lblModificata);
	}
}
