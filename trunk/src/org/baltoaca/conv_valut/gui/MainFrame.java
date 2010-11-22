package org.baltoaca.conv_valut.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;

import org.baltoaca.conv_valut.computer.Currency;
import org.baltoaca.conv_valut.mvc.ConvValutarModel;
import org.baltoaca.conv_valut.mvc.Model;
import org.baltoaca.conv_valut.mvc.ModelListener;
import org.dyno.visual.swing.layouts.Constraints;
import org.dyno.visual.swing.layouts.GroupLayout;
import org.dyno.visual.swing.layouts.Leading;

//VS4E -- DO NOT REMOVE THIS LINE!
public class MainFrame extends JFrame implements ModelListener {

	private static final long serialVersionUID = 1L;
	private JLabel lbDateName;
	private JLabel lbDate;
	private JList lsFrom;
	private JList lsTo;
	private JScrollPane jScrollPane0;
	private JScrollPane jScrollPane1;
	private JMenuItem mnItemExit;
	private JMenu mnFile;
	private JMenu mnOptions;
	private JMenuItem mnItemGuide;
	private JMenuItem mnItemAbout;
	private JMenu mnHelp;
	private JMenuBar jMenuBar0;
	private JButton btSwitch;
	private JLabel lbConvRateName1;
	private JLabel lbConvRateName2;
	private JLabel lbSumName;
	private JFormattedTextField tfSum;
	private JFormattedTextField tfConvRate;
	private JLabel lbFromCurrency;
	private JLabel lbVatName;
	private JLabel lbResultAndVatName;
	private JLabel lbResultName;
	private JLabel lbVat;
	private JLabel lbResultAndVat;
	private JLabel lbToCurrency;
	private JLabel lbResult;
	private boolean listsNeedToBeUpdated = true;
	private static final int NR_OF_FRACTION_DIGITS = 2;

	NumberFormat numberFormat = NumberFormat.getInstance(new Locale("en"));
	NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
	private static final String PREFERRED_LOOK_AND_FEEL = "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel";

	public MainFrame() {
		numberFormat.setMaximumFractionDigits(NR_OF_FRACTION_DIGITS);
		numberFormat.setMinimumFractionDigits(0);
		numberFormatter.setCommitsOnValidEdit(true);
		initComponents();
	}

	private void initComponents() {
		setLayout(new GroupLayout());
		add(getJScrollPane1(), new Constraints(new Leading(273, 234, 6, 6),
				new Leading(73, 174, 6, 6)));
		add(getJScrollPane0(), new Constraints(new Leading(30, 234, 10, 10),
				new Leading(73, 174, 6, 6)));
		add(getLbDateName(), new Constraints(new Leading(231, 10, 10),
				new Leading(19, 10, 10)));
		add(getLbDate(), new Constraints(new Leading(222, 10, 10), new Leading(
				39, 6, 6)));
		add(getBtSwitch(), new Constraints(new Leading(217, 100, 6, 6),
				new Leading(263, 10, 10)));
		add(getLbConvRateName1(), new Constraints(new Leading(581, 10, 10),
				new Leading(73, 6, 6)));
		add(getLbConvRateName2(), new Constraints(new Leading(641, 10, 10),
				new Leading(93, 6, 6)));
		add(getLbSumName(), new Constraints(new Leading(647, 10, 10),
				new Leading(49, 6, 6)));
		add(getTfSum(), new Constraints(new Leading(710, 112, 10, 10),
				new Leading(39, 6, 6)));
		add(getTfConvRate(), new Constraints(new Leading(710, 112, 10, 10),
				new Leading(80, 6, 6)));
		add(getLbVatName(), new Constraints(new Leading(623, 10, 10),
				new Leading(183, 10, 10)));
		add(getLbResultAndVatName(), new Constraints(new Leading(602, 10, 10),
				new Leading(205, 10, 10)));
		add(getLbResultName(), new Constraints(new Leading(636, 10, 10),
				new Leading(247, 10, 10)));
		add(getLbVat(), new Constraints(new Leading(716, 116, 10, 10),
				new Leading(183, 10, 10)));
		add(getLbResultAndVat(), new Constraints(new Leading(716, 116, 10, 10),
				new Leading(207, 6, 6)));
		add(getLbToCurrency(), new Constraints(new Leading(847, 10, 10),
				new Leading(247, 10, 10)));
		add(getLbResult(), new Constraints(new Leading(715, 116, 10, 10),
				new Leading(243, 6, 6)));
		add(getLbFromCurrency(), new Constraints(new Leading(843, 6, 6),
				new Leading(43, 6, 6)));
		setJMenuBar(getJMenuBar0());
		setSize(908, 328);
	}

	public JLabel getLbResult() {
		if (lbResult == null) {
			lbResult = new JLabel();
			lbResult.setHorizontalAlignment(SwingConstants.CENTER);
			lbResult.setText("3524,57");
			lbResult.setBorder(BorderFactory.createEtchedBorder(
					EtchedBorder.LOWERED, null, null));
		}
		return lbResult;
	}

	public JLabel getLbToCurrency() {
		if (lbToCurrency == null) {
			lbToCurrency = new JLabel();
			lbToCurrency.setText("LEI");
		}
		return lbToCurrency;
	}

	public JLabel getLbResultAndVat() {
		if (lbResultAndVat == null) {
			lbResultAndVat = new JLabel();
			lbResultAndVat.setHorizontalAlignment(SwingConstants.CENTER);
			lbResultAndVat.setText("jLabel10");
			lbResultAndVat.setBorder(BorderFactory.createEtchedBorder(
					EtchedBorder.LOWERED, null, null));
		}
		return lbResultAndVat;
	}

	public JLabel getLbVat() {
		if (lbVat == null) {
			lbVat = new JLabel();
			lbVat.setHorizontalAlignment(SwingConstants.CENTER);
			lbVat.setText("jLabel9");
			lbVat.setBorder(BorderFactory.createEtchedBorder(
					EtchedBorder.LOWERED, null, null));
		}
		return lbVat;
	}

	public JLabel getLbResultName() {
		if (lbResultName == null) {
			lbResultName = new JLabel();
			lbResultName.setForeground(Color.red);
			lbResultName.setText("Rezultat");
		}
		return lbResultName;
	}

	public JLabel getLbResultAndVatName() {
		if (lbResultAndVatName == null) {
			lbResultAndVatName = new JLabel();
			lbResultAndVatName.setText("Rezultat + TVA");
		}
		return lbResultAndVatName;
	}

	public JLabel getLbVatName() {
		if (lbVatName == null) {
			lbVatName = new JLabel();
			lbVatName.setText("TVA ("
					+ new Integer((int) (ConvValutarModel.VAT * 100)) + "%)");
		}
		return lbVatName;
	}

	public JLabel getLbFromCurrency() {
		if (lbFromCurrency == null) {
			lbFromCurrency = new JLabel();
			lbFromCurrency.setText("EUR");
		}
		return lbFromCurrency;
	}

	public JFormattedTextField getTfConvRate() {
		if (tfConvRate == null) {
			tfConvRate = new JFormattedTextField(numberFormatter);
			tfConvRate.setHorizontalAlignment(SwingConstants.CENTER);
			tfConvRate.setValue(new Double(0));
			tfConvRate.addFocusListener(new FormattedTextFieldFocusListener());
		}
		return tfConvRate;
	}

	public JFormattedTextField getTfSum() {
		if (tfSum == null) {
			tfSum = new JFormattedTextField(numberFormatter);
			tfSum.setHorizontalAlignment(SwingConstants.CENTER);
			tfSum.setValue(new Double(1));
			tfSum.addFocusListener(new FormattedTextFieldFocusListener());

		}
		return tfSum;
	}

	public JLabel getLbSumName() {
		if (lbSumName == null) {
			lbSumName = new JLabel();
			lbSumName.setText("Sumã");
		}
		return lbSumName;
	}

	public JLabel getLbConvRateName2() {
		if (lbConvRateName2 == null) {
			lbConvRateName2 = new JLabel();
			lbConvRateName2.setText("proprie");
		}
		return lbConvRateName2;
	}

	public JLabel getLbConvRateName1() {
		if (lbConvRateName1 == null) {
			lbConvRateName1 = new JLabel();
			lbConvRateName1.setText("Ratã de conversie");
		}
		return lbConvRateName1;
	}

	public JButton getBtSwitch() {
		if (btSwitch == null) {
			btSwitch = new JButton();
			btSwitch.setMnemonic(KeyEvent.VK_S);
			btSwitch.setText("Inverseazã");
		}
		return btSwitch;
	}

	public JMenuBar getJMenuBar0() {
		if (jMenuBar0 == null) {
			jMenuBar0 = new JMenuBar();
			jMenuBar0.add(getMnFile());
			jMenuBar0.add(getMnOptions());
			jMenuBar0.add(getMnHelp());
		}
		return jMenuBar0;
	}

	public JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu();
			mnHelp.setText("Ajutor");
			mnHelp.add(getMnItemGuide());
			mnHelp.add(getMnItemAbout());
			mnHelp.setMnemonic(KeyEvent.VK_A);
		}
		return mnHelp;
	}

	public JMenuItem getMnItemAbout() {
		if (mnItemAbout == null) {
			mnItemAbout = new JMenuItem();
			mnItemAbout.setText("Despre");
			mnItemAbout.setMnemonic(KeyEvent.VK_D);
		}
		return mnItemAbout;
	}

	public JMenuItem getMnItemGuide() {
		if (mnItemGuide == null) {
			mnItemGuide = new JMenuItem();
			mnItemGuide.setText("Ghid utilizare");
			mnItemGuide.setMnemonic(KeyEvent.VK_G);
		}
		return mnItemGuide;
	}

	public JMenu getMnOptions() {
		if (mnOptions == null) {
			mnOptions = new JMenu();
			mnOptions.setText("Opþiuni");
			mnOptions.setMnemonic(KeyEvent.VK_O);
		}
		return mnOptions;
	}

	public JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu();
			mnFile.setText("File");
			mnFile.add(getMnItemExit());
			mnFile.setMnemonic(KeyEvent.VK_F);
		}
		return mnFile;
	}

	public JMenuItem getMnItemExit() {
		if (mnItemExit == null) {
			mnItemExit = new JMenuItem();
			mnItemExit.setText("Ieºire");
			mnItemExit.setMnemonic(KeyEvent.VK_E);
		}
		return mnItemExit;
	}

	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1
					.setBorder(BorderFactory.createTitledBorder(null, "în",
							TitledBorder.CENTER, TitledBorder.ABOVE_TOP,
							new Font("SansSerif", Font.BOLD, 12), new Color(59,
									59, 59)));
			jScrollPane1.setViewportView(getLsTo());
		}
		return jScrollPane1;
	}

	public JList getLsTo() {
		if (lsTo == null) {
			lsTo = new JList();
			lsTo.setBorder(null);
			lsTo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			DefaultListModel listModel = new DefaultListModel();
			listModel.addElement("item0");
			listModel.addElement("item1");
			listModel.addElement("item2");
			listModel.addElement("item3");
			lsTo.setModel(listModel);
		}
		return lsTo;
	}

	public JScrollPane getJScrollPane0() {
		if (jScrollPane0 == null) {
			jScrollPane0 = new JScrollPane();
			jScrollPane0.setBorder(BorderFactory
					.createTitledBorder(null, "Schimbã", TitledBorder.CENTER,
							TitledBorder.ABOVE_TOP, new Font("SansSerif",
									Font.BOLD, 12), new Color(59, 59, 59)));
			jScrollPane0.setViewportView(getLsFrom());
		}
		return jScrollPane0;
	}

	public JList getLsFrom() {
		if (lsFrom == null) {
			lsFrom = new JList();
			lsFrom.setBorder(null);
			lsFrom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			DefaultListModel listModel = new DefaultListModel();
			listModel.addElement("AED - Dirhamul Emiratelor Arabe");
			listModel.addElement("item1");
			listModel.addElement("item2");
			listModel.addElement("item3");
			lsFrom.setModel(listModel);
		}
		return lsFrom;
	}

	public JLabel getLbDate() {
		if (lbDate == null) {
			lbDate = new JLabel();
			lbDate.setText("14 August 2010");
			lbDate.setBorder(BorderFactory.createEtchedBorder(
					EtchedBorder.LOWERED, null, null));
		}
		return lbDate;
	}

	public JLabel getLbDateName() {
		if (lbDateName == null) {
			lbDateName = new JLabel();
			lbDateName.setText("Data cursului");
		}
		return lbDateName;
	}

	@SuppressWarnings("unused")
	public static void installLnF() {
		try {
			String lnfClassname = PREFERRED_LOOK_AND_FEEL;
			if (lnfClassname == null)
				lnfClassname = UIManager.getCrossPlatformLookAndFeelClassName();
			UIManager.setLookAndFeel(lnfClassname);
		} catch (Exception e) {
			System.err.println("Cannot install " + PREFERRED_LOOK_AND_FEEL
					+ " on this platform:" + e.getMessage());
		}
	}

	/**
	 * Main entry of the class. Note: This class is only created so that you can
	 * easily preview the result at runtime. It is not expected to be managed by
	 * the designer. You can modify it as you like.
	 */
	public static void main(String[] args) {
		installLnF();
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				MainFrame frame = new MainFrame();
				frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
				frame.setTitle("Convertor Valutar");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		});
	}

	// TODO override hashCode and equals

	@Override
	public void update(Model m, final Object obj) {

		final ConvValutarModel myModel = (ConvValutarModel) m;
		final HashMap<String, String> labelsTextMap;

		final Currency[] currenciesArray = myModel.getXmlInfo().getCurrencies()
				.toArray(new Currency[0]);
		final String lbDateText = myModel.getXmlInfo().dateToString();
		
		labelsTextMap = generateLabelsTextMapFromModel(myModel);

		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				updateJLists(currenciesArray);

				updateDate(lbDateText);

				updateResultLabels(labelsTextMap);
			}

			private void updateJLists(final Currency[] currenciesArray) {
				if (listsNeedToBeUpdated) {
					lsFrom.setListData(currenciesArray);
					lsTo.setListData(currenciesArray);
					listsNeedToBeUpdated = false;
				}
			}

			private void updateDate(final String lbDateText) {
				lbDate.setText(lbDateText);
			}

			private void updateResultLabels(HashMap<String, String> labelsText) {
				lbResult.setText(labelsText.get("lbResultText").toString());
				lbVat.setText(labelsText.get("lbVatText").toString());
				lbResultAndVat.setText(labelsText.get("lbResultAndVatText")
						.toString());
				lbFromCurrency.setText(labelsText.get("lbFromCurrencyText")
						.toString());
				lbToCurrency.setText(labelsText.get("lbToCurrencyText")
						.toString());
			}

		});

	}

	private HashMap<String, String> generateLabelsTextMapFromModel(final ConvValutarModel myModel) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("lbResultText",
				String.valueOf(numberFormat.format(myModel.getResult())));
		map.put("lbVatText",
				String.valueOf(numberFormat.format(myModel.getVat())));
		map.put("lbResultAndVatText",
				String.valueOf(numberFormat.format(myModel.getResultAndVat())));
		map.put("lbFromCurrencyText", myModel.getFromCurrencyLabel());
		map.put("lbToCurrencyText", myModel.getToCurrencyLabel());
		
		return map;
	}

	
	public void selectCurrencyInFromList(String currencyShortName){
		selectCurrencyInListAndScroll(currencyShortName,lsFrom);
	}
	
	public void selectCurrencyInToList(String currencyShortName){
		selectCurrencyInListAndScroll(currencyShortName,lsTo);
	}
	
	private void selectCurrencyInListAndScroll(String currencyShortName,JList list){
		boolean shouldScroll = true;
		list.setSelectedValue(new Currency(currencyShortName), shouldScroll);
	}
	
	
	/**
	 * Used to call <code>selectAll()</code> on the
	 * <code>JFormattedTextField</code>'s when they acquire keyboard focus
	 * 
	 * @author VlaD
	 * 
	 */
	private class FormattedTextFieldFocusListener implements FocusListener {

		@Override
		public void focusGained(final FocusEvent e) {

			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					((JFormattedTextField) (e.getSource())).selectAll();
				}
			});

		}

		@Override
		public void focusLost(FocusEvent e) {
		}

	}

}
