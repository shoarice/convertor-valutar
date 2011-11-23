package gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EditorView {

	private JFrame frmWritersCenter;
	private JTextField txtFldAuthor;
	private JTextField txtFldTitle;
	private JTextField txtFldSource;
	private JComboBox comboBoxCat;
	private JComboBox comboBoxSubCat;
	private JButton btnPublish;
	private JButton btnEdit;
	private JButton btnDelete;
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					EditorView window = new EditorView();
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
	public EditorView() {
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
		scrollPane.setBounds(477, 20, 212, 354);
		frmWritersCenter.getContentPane().add(scrollPane);
		
		JList list = new JList();
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 126, 440, 248);
		frmWritersCenter.getContentPane().add(scrollPane_1);
		
		JTextArea txtrEditDocument = new JTextArea();
		txtrEditDocument.setText("Your text here...");
		scrollPane_1.setViewportView(txtrEditDocument);
		
		JLabel lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(25, 22, 61, 16);
		frmWritersCenter.getContentPane().add(lblAuthor);
		
		txtFldAuthor = new JTextField();
		txtFldAuthor.setBounds(85, 16, 157, 28);
		frmWritersCenter.getContentPane().add(txtFldAuthor);
		txtFldAuthor.setColumns(10);
		
		JLabel lblTitle = new JLabel("Title:");
		lblTitle.setBounds(25, 60, 61, 16);
		frmWritersCenter.getContentPane().add(lblTitle);
		
		txtFldTitle = new JTextField();
		txtFldTitle.setColumns(10);
		txtFldTitle.setBounds(85, 54, 157, 28);
		frmWritersCenter.getContentPane().add(txtFldTitle);
		
		JLabel lblSource = new JLabel("Source:");
		lblSource.setBounds(25, 94, 61, 16);
		frmWritersCenter.getContentPane().add(lblSource);
		
		txtFldSource = new JTextField();
		txtFldSource.setColumns(10);
		txtFldSource.setBounds(85, 88, 157, 28);
		frmWritersCenter.getContentPane().add(txtFldSource);
		
		JLabel lblCategory = new JLabel("Category:");
		lblCategory.setBounds(254, 40, 68, 16);
		frmWritersCenter.getContentPane().add(lblCategory);
		
		comboBoxCat = new JComboBox();
		comboBoxCat.setBounds(347, 36, 118, 27);
		frmWritersCenter.getContentPane().add(comboBoxCat);
		
		JLabel lblSubcategory = new JLabel("Subcategory:");
		lblSubcategory.setBounds(254, 75, 81, 16);
		frmWritersCenter.getContentPane().add(lblSubcategory);
		
		comboBoxSubCat = new JComboBox();
		comboBoxSubCat.setBounds(347, 71, 118, 27);
		frmWritersCenter.getContentPane().add(comboBoxSubCat);
		
		btnPublish = new JButton("Publish");
		btnPublish.setBounds(48, 386, 378, 29);
		frmWritersCenter.getContentPane().add(btnPublish);
		
		btnEdit = new JButton("Edit");
		btnEdit.setBounds(477, 386, 212, 29);
		frmWritersCenter.getContentPane().add(btnEdit);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(477, 425, 212, 29);
		frmWritersCenter.getContentPane().add(btnDelete);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(48, 425, 378, 29);
		frmWritersCenter.getContentPane().add(btnClose);
	}
}
