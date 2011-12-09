package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.reader.ReaderModel;
import model.reader.StireReaderEveniment;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import javax.swing.JTextField;

public class ReaderGuiView implements Observer{

	private JFrame frmReader;
	private JCheckBox chckbxStocks;
	private JCheckBox chckbxEconomy;
	private JCheckBox chckbxBusiness;
	private JCheckBox chckbxFinance;
	private JCheckBox chckbxFootball;
	private JCheckBox chckbxTenis;
	private JCheckBox chckbxHockey;
	private JCheckBox chckbxSports;
	private JCheckBox chckbxBasketball;
	private JCheckBox chckbxHealth;
	private JCheckBox chckbxDiet;
	private JCheckBox chckbxFashion;
	private JCheckBox chckbxLifestyle;
	private JCheckBox chckbxPc;
	private JCheckBox chckbxCelebrities;
	private JCheckBox chckbxMondane;
	private JButton btnSubmit;
	private JButton btnClose;
    private ArrayList<JCheckBox> checkBoxList;
    private ArrayList<JCheckBox> financeList;
    private ArrayList<JCheckBox> sportsList;
    private ArrayList<JCheckBox> lifestyleList;
    private ArrayList<JCheckBox> fashionableList;
	private JList list;
	public JCheckBox chckbxPublished;
	public JCheckBox chckbxEdited;
	public JCheckBox chckbxDeleted;
	public JCheckBox getChckbxPublished() {
		return chckbxPublished;
	}

	public JCheckBox getChckbxEdited() {
		return chckbxEdited;
	}

	public JCheckBox getChckbxDeleted() {
		return chckbxDeleted;
	}

	public JLabel lblReceiveNewsThat;
	private JTextField tfTitlu;
	private JTextField tfAutor;
	private JTextField tfSursa;
    
	/**
	 * @return the checkBoxList
	 */
	public ArrayList<JCheckBox> getCheckBoxList() {
		return checkBoxList;
	}

	/**
	 * @return the frmReader
	 */
	public JFrame getFrmReader() {
		return frmReader;
	}

	/**
	 * @return the chckbxStocks
	 */
	public JCheckBox getChckbxStocks() {
		return chckbxStocks;
	}

	/**
	 * @return the chckbxEconomy
	 */
	public JCheckBox getChckbxEconomy() {
		return chckbxEconomy;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	/**
	 * @return the chckbxBusiness
	 */
	public JCheckBox getChckbxBusiness() {
		return chckbxBusiness;
	}

	/**
	 * @return the chckbxFinance
	 */
	public JCheckBox getChckbxFinance() {
		return chckbxFinance;
	}

	/**
	 * @return the chckbxFootball
	 */
	public JCheckBox getChckbxFootball() {
		return chckbxFootball;
	}

	/**
	 * @return the chckbxTenis
	 */
	public JCheckBox getChckbxTenis() {
		return chckbxTenis;
	}

	/**
	 * @return the chckbxHockey
	 */
	public JCheckBox getChckbxHockey() {
		return chckbxHockey;
	}

	/**
	 * @return the chckbxSports
	 */
	public JCheckBox getChckbxSports() {
		return chckbxSports;
	}

	/**
	 * @return the chckbxBasketball
	 */
	public JCheckBox getChckbxBasketball() {
		return chckbxBasketball;
	}

	/**
	 * @return the chckbxHealth
	 */
	public JCheckBox getChckbxHealth() {
		return chckbxHealth;
	}

	/**
	 * @return the chckbxDiet
	 */
	public JCheckBox getChckbxDiet() {
		return chckbxDiet;
	}

	/**
	 * @return the chckbxFashion
	 */
	public JCheckBox getChckbxFashion() {
		return chckbxFashion;
	}

	/**
	 * @return the chckbxLifestyle
	 */
	public JCheckBox getChckbxLifestyle() {
		return chckbxLifestyle;
	}

	/**
	 * @return the chckbxPc
	 */
	public JCheckBox getChckbxPc() {
		return chckbxPc;
	}

	/**
	 * @return the chckbxCelebrities
	 */
	public JCheckBox getChckbxCelebrities() {
		return chckbxCelebrities;
	}

	/**
	 * @return the chckbxMondane
	 */
	public JCheckBox getChckbxMondane() {
		return chckbxMondane;
	}

	/**
	 * @return the btnSubmit
	 */
	public JButton getBtnSubmit() {
		return btnSubmit;
	}

	/**
	 * @return the btnClose
	 */
	public JButton getBtnClose() {
		return btnClose;
	}
	
	public JTextField getTfTitlu() {
		return tfTitlu;
	}

	public JTextField getTfAutor() {
		return tfAutor;
	}

	public JTextField getTfSursa() {
		return tfSursa;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					ReaderGuiView window = new ReaderGuiView();
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
	public ReaderGuiView() {
		initialize();
	}
	
	public void show(){
		frmReader.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		checkBoxList = new ArrayList<JCheckBox>();
		financeList = new ArrayList<JCheckBox>();
		sportsList = new ArrayList<JCheckBox>();
		lifestyleList = new ArrayList<JCheckBox>();
		fashionableList = new ArrayList<JCheckBox>();
		
		frmReader = new JFrame();
		frmReader.setResizable(false);
		frmReader.setTitle("Reader's Center");
		frmReader.setBounds(100, 100, 713, 512);
		frmReader.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmReader.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Choose your category");
		lblNewLabel.setBounds(6, 21, 148, 16);
		frmReader.getContentPane().add(lblNewLabel);
		
		chckbxStocks = new JCheckBox("Stocks");
		chckbxStocks.setForeground(new Color(0, 0, 205));
		chckbxStocks.setBounds(26, 74, 128, 23);
		frmReader.getContentPane().add(chckbxStocks);
		checkBoxList.add(chckbxStocks);
		financeList.add(chckbxStocks);
		chckbxStocks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chckbxStocks.isSelected()) {
					chckbxFinance.setSelected(chckbxStocks.isSelected());
				}
			}
		});
		
		chckbxEconomy = new JCheckBox("Economy");
		chckbxEconomy.setForeground(new Color(0, 0, 205));
		chckbxEconomy.setBounds(26, 99, 128, 23);
		frmReader.getContentPane().add(chckbxEconomy);
		checkBoxList.add(chckbxEconomy);
		financeList.add(chckbxEconomy);
		chckbxEconomy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chckbxEconomy.isSelected()) {
					chckbxFinance.setSelected(chckbxEconomy.isSelected());
				}
			}
		});
		
		chckbxBusiness = new JCheckBox("Business");
		chckbxBusiness.setForeground(new Color(0, 0, 205));
		chckbxBusiness.setBounds(26, 124, 128, 23);
		frmReader.getContentPane().add(chckbxBusiness);
		checkBoxList.add(chckbxBusiness);
		financeList.add(chckbxBusiness);
		chckbxBusiness.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chckbxBusiness.isSelected()) {
					chckbxFinance.setSelected(chckbxBusiness.isSelected());
				}
			}
		});
		
		chckbxFinance = new JCheckBox("Finance");
		chckbxFinance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (JCheckBox jcb : financeList) {
					jcb.setSelected(chckbxFinance.isSelected());
				}
			}
		});
		chckbxFinance.setForeground(new Color(0, 0, 205));
		chckbxFinance.setBounds(16, 49, 128, 23);
		frmReader.getContentPane().add(chckbxFinance);
		
		chckbxFootball = new JCheckBox("Football");
		chckbxFootball.setForeground(new Color(50, 205, 50));
		chckbxFootball.setBounds(26, 182, 128, 23);
		frmReader.getContentPane().add(chckbxFootball);
		checkBoxList.add(chckbxFootball);
		sportsList.add(chckbxFootball);
		chckbxFootball.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chckbxFootball.isSelected()) {
					chckbxSports.setSelected(chckbxFootball.isSelected());
				}
			}
		});
		
		chckbxTenis = new JCheckBox("Tenis");
		chckbxTenis.setForeground(new Color(50, 205, 50));
		chckbxTenis.setBounds(26, 207, 128, 23);
		frmReader.getContentPane().add(chckbxTenis);
		checkBoxList.add(chckbxTenis);
		sportsList.add(chckbxTenis);
		chckbxTenis.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chckbxTenis.isSelected()) {
					chckbxSports.setSelected(chckbxTenis.isSelected());
				}
			}
		});
		
		chckbxHockey = new JCheckBox("Hockey");
		chckbxHockey.setForeground(new Color(50, 205, 50));
		chckbxHockey.setBounds(26, 232, 128, 23);
		frmReader.getContentPane().add(chckbxHockey);
		checkBoxList.add(chckbxHockey);
		sportsList.add(chckbxHockey);
		chckbxHockey.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chckbxHockey.isSelected()) {
					chckbxSports.setSelected(chckbxHockey.isSelected());
				}
			}
		});
		
		chckbxSports = new JCheckBox("Sports");
		chckbxSports.setForeground(new Color(50, 205, 50));
		chckbxSports.setBounds(16, 157, 128, 23);
		frmReader.getContentPane().add(chckbxSports);
		chckbxSports.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (JCheckBox jcb : sportsList) {
					jcb.setSelected(chckbxSports.isSelected());
				}
			}
		});
		
		chckbxBasketball = new JCheckBox("Basketball");
		chckbxBasketball.setForeground(new Color(50, 205, 50));
		chckbxBasketball.setBounds(26, 257, 128, 23);
		frmReader.getContentPane().add(chckbxBasketball);
		checkBoxList.add(chckbxBasketball);
		sportsList.add(chckbxBasketball);
		chckbxBasketball.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chckbxBasketball.isSelected()) {
					chckbxSports.setSelected(chckbxBasketball.isSelected());
				}
			}
		});
		
		chckbxHealth = new JCheckBox("Health");
		chckbxHealth.setForeground(new Color(255, 0, 0));
		chckbxHealth.setBounds(26, 316, 128, 23);
		frmReader.getContentPane().add(chckbxHealth);
		checkBoxList.add(chckbxHealth);
		lifestyleList.add(chckbxHealth);
		chckbxHealth.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chckbxHealth.isSelected()) {
					chckbxLifestyle.setSelected(chckbxHealth.isSelected());
				}
			}
		});
		
		chckbxDiet = new JCheckBox("Diet");
		chckbxDiet.setForeground(new Color(255, 0, 0));
		chckbxDiet.setBounds(26, 341, 128, 23);
		frmReader.getContentPane().add(chckbxDiet);
		checkBoxList.add(chckbxDiet);
		lifestyleList.add(chckbxDiet);
		chckbxDiet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chckbxDiet.isSelected()) {
					chckbxLifestyle.setSelected(chckbxDiet.isSelected());
				}
			}
		});
		
		chckbxFashion = new JCheckBox("Fashion");
		chckbxFashion.setForeground(new Color(255, 0, 0));
		chckbxFashion.setBounds(26, 366, 128, 23);
		frmReader.getContentPane().add(chckbxFashion);
		checkBoxList.add(chckbxFashion);
		lifestyleList.add(chckbxFashion);
		chckbxFashion.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chckbxFashion.isSelected()) {
					chckbxLifestyle.setSelected(chckbxFashion.isSelected());
				}
			}
		});
		
		chckbxLifestyle = new JCheckBox("Lifestyle");
		chckbxLifestyle.setForeground(new Color(255, 0, 0));
		chckbxLifestyle.setBounds(16, 291, 128, 23);
		frmReader.getContentPane().add(chckbxLifestyle);
		chckbxLifestyle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (JCheckBox jcb : lifestyleList) {
					jcb.setSelected(chckbxLifestyle.isSelected());
				}
			}
		});
		
		chckbxPc = new JCheckBox("P&C");
		chckbxPc.setForeground(new Color(255, 0, 255));
		chckbxPc.setBounds(26, 426, 128, 23);
		frmReader.getContentPane().add(chckbxPc);
		checkBoxList.add(chckbxPc);
		fashionableList.add(chckbxPc);
		chckbxPc.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chckbxPc.isSelected()) {
					chckbxMondane.setSelected(chckbxPc.isSelected());
				}
			}
		});
		
		chckbxCelebrities = new JCheckBox("Celebrities");
		chckbxCelebrities.setForeground(new Color(255, 0, 255));
		chckbxCelebrities.setBounds(26, 451, 128, 23);
		frmReader.getContentPane().add(chckbxCelebrities);
		checkBoxList.add(chckbxCelebrities);
		fashionableList.add(chckbxCelebrities);
		chckbxCelebrities.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (!chckbxCelebrities.isSelected()) {
					chckbxMondane.setSelected(chckbxCelebrities.isSelected());
				}
			}
		});
		
		
		chckbxMondane = new JCheckBox("Fashionable");
		chckbxMondane.setForeground(new Color(255, 0, 255));
		chckbxMondane.setBounds(16, 401, 128, 23);
		frmReader.getContentPane().add(chckbxMondane);
		chckbxMondane.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				for (JCheckBox jcb : fashionableList) {
					jcb.setSelected(chckbxMondane.isSelected());
				}
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(214, 49, 457, 315);
		frmReader.getContentPane().add(scrollPane);
		
		list = new JList();
		scrollPane.setViewportView(list);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(280, 444, 117, 29);
		frmReader.getContentPane().add(btnSubmit);
		
		btnClose = new JButton("Close");
		btnClose.setBounds(509, 448, 117, 29);
		frmReader.getContentPane().add(btnClose);
		
		chckbxPublished = new JCheckBox("Published");
		chckbxPublished.setBounds(419, 18, 71, 23);
		chckbxPublished.setSelected(true);
		frmReader.getContentPane().add(chckbxPublished);
		
		chckbxEdited = new JCheckBox("Edited");
		chckbxEdited.setBounds(515, 18, 63, 23);
		chckbxEdited.setSelected(true);
		frmReader.getContentPane().add(chckbxEdited);
		
		chckbxDeleted = new JCheckBox("Deleted");
		chckbxDeleted.setBounds(600, 18, 71, 23);
		chckbxDeleted.setSelected(true);
		frmReader.getContentPane().add(chckbxDeleted);
		
		lblReceiveNewsThat = new JLabel("Receive news that have been: ");
		lblReceiveNewsThat.setBounds(214, 22, 168, 14);
		frmReader.getContentPane().add(lblReceiveNewsThat);
		
		JLabel lblFilterOn = new JLabel("Filter on:");
		lblFilterOn.setBounds(214, 380, 46, 14);
		frmReader.getContentPane().add(lblFilterOn);
		
		JLabel lblTitlu = new JLabel("Titlu");
		lblTitlu.setBounds(268, 380, 46, 14);
		frmReader.getContentPane().add(lblTitlu);
		
		JLabel lblAutor = new JLabel("Autor");
		lblAutor.setBounds(268, 405, 46, 14);
		frmReader.getContentPane().add(lblAutor);
		
		JLabel lblSursa = new JLabel("Sursa");
		lblSursa.setBounds(483, 405, 46, 14);
		frmReader.getContentPane().add(lblSursa);
		
		tfTitlu = new JTextField();
		tfTitlu.setBounds(324, 375, 302, 20);
		frmReader.getContentPane().add(tfTitlu);
		tfTitlu.setColumns(10);
		
		tfAutor = new JTextField();
		tfAutor.setBounds(324, 402, 146, 20);
		frmReader.getContentPane().add(tfAutor);
		tfAutor.setColumns(10);
		
		tfSursa = new JTextField();
		tfSursa.setBounds(531, 402, 95, 20);
		frmReader.getContentPane().add(tfSursa);
		tfSursa.setColumns(10);
		frmReader.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, chckbxFinance, chckbxStocks, chckbxEconomy, chckbxBusiness, chckbxSports, chckbxFootball, chckbxTenis, chckbxHockey, chckbxBasketball}));
	}

	@Override
	public void update(Observable o, Object arg) {
			ReaderModel model = (ReaderModel) o;
			List<StireReaderEveniment> l = model.getStiri();
			
			list.setListData(l.toArray());
	}
}
