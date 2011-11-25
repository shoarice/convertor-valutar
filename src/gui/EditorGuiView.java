package gui;

import java.awt.EventQueue;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import main.ManipulantEditor;
import model.editor.EditorModel;

public class EditorGuiView implements Observer{

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
	private JTree tree;
	private JList list;
	private JTextArea txtrEditDocument;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					//new ManipulantEditor(1);
					EditorGuiView view = new EditorGuiView();
					view.frmWritersCenter.show();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EditorGuiView() {
		initialize();
	}

	public void show(){
		frmWritersCenter.setVisible(true);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWritersCenter = new JFrame();
		frmWritersCenter.setTitle("Writer's Center");
		frmWritersCenter.setResizable(false);
		frmWritersCenter.setBounds(100, 100, 714, 513);
		frmWritersCenter.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmWritersCenter.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(477, 16, 212, 358);
		frmWritersCenter.getContentPane().add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(25, 126, 440, 248);
		frmWritersCenter.getContentPane().add(scrollPane_1);
		
		txtrEditDocument = new JTextArea();
		txtrEditDocument.setText("Your text here...");
		txtrEditDocument.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtrEditDocument.getText().equals("Your text here..."))
					txtrEditDocument.selectAll();
			}
		});
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
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(252, 16, 213, 99);
		frmWritersCenter.getContentPane().add(scrollPane_2);
		
		tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Domenii") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Finance");
						node_1.add(new DefaultMutableTreeNode("Stocks"));
						node_1.add(new DefaultMutableTreeNode("Economy"));
						node_1.add(new DefaultMutableTreeNode("Business"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Sports");
						node_1.add(new DefaultMutableTreeNode("Football"));
						node_1.add(new DefaultMutableTreeNode("Tenis"));
						node_1.add(new DefaultMutableTreeNode("Hockey"));
						node_1.add(new DefaultMutableTreeNode("Basketball"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Lifestyle");
						node_1.add(new DefaultMutableTreeNode("Health"));
						node_1.add(new DefaultMutableTreeNode("Diet"));
						node_1.add(new DefaultMutableTreeNode("Fashion"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Fashionable");
						node_1.add(new DefaultMutableTreeNode("P&C"));
						node_1.add(new DefaultMutableTreeNode("Celebrities"));
					add(node_1);
				}
			}
		));
		tree.setShowsRootHandles(true);
		tree.setRootVisible(false);
		scrollPane_2.setViewportView(tree);
	}

	public void showErrorMsg(String msg) {
		JOptionPane.showMessageDialog(frmWritersCenter, msg,
				"Error", JOptionPane.ERROR_MESSAGE);
	}
	
	public JFrame getFrmWritersCenter() {
		return frmWritersCenter;
	}

	public JTextField getTxtFldAuthor() {
		return txtFldAuthor;
	}

	public JTextField getTxtFldTitle() {
		return txtFldTitle;
	}

	public JTextField getTxtFldSource() {
		return txtFldSource;
	}

	public JComboBox getComboBoxCat() {
		return comboBoxCat;
	}

	public JComboBox getComboBoxSubCat() {
		return comboBoxSubCat;
	}

	public JButton getBtnPublish() {
		return btnPublish;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnClose() {
		return btnClose;
	}

	public JTree getTree() {
		return tree;
	}

	public JList getList() {
		return list;
	}

	public JTextArea getTxtrEditDocument() {
		return txtrEditDocument;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		final EditorModel model = (EditorModel) o;
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				list.setListData(model.getStiriWrappers());
			}
		});
	}
}
