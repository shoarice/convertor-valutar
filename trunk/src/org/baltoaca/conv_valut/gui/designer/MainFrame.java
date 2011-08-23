package org.baltoaca.conv_valut.gui.designer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;
import java.text.NumberFormat;
import java.util.HashMap;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.NumberFormatter;

import org.baltoaca.conv_valut.computer.Currency;
import org.baltoaca.conv_valut.mvc.ConvValutarModel;
import org.baltoaca.conv_valut.mvc.Model;
import org.baltoaca.conv_valut.mvc.ModelListener;

public class MainFrame implements ModelListener{

	private JFrame frame;
	private JLabel lblData;
	private JList lsTo;
	private JList lsFrom;
	private JMenuItem mntmExit;
	private JMenuItem mntmGuide;
	private JMenuItem mntmAbout;
	private JButton btnReverse;
	private JLabel lblResult;
	private JLabel lblResultPlusTva;
	private JLabel lblTva;
	private JLabel lblFromCurrency;
	private JLabel lblToCurrency;
	public JFormattedTextField txtSum;
	public JFormattedTextField txtRate;

	private boolean listsNeedToBeUpdated = true;
	private static final int NR_OF_FRACTION_DIGITS = 2;
	private NumberFormatter numberFormatter;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MainFrame();
	}

	/**
	 * Create the application.
	 */
	public MainFrame() {
		numberFormatter = initFormatter();
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					initialize();
				} catch (Exception e) {
					e.printStackTrace();
					System.exit(0);
				}
			}
		});
		
	}

	private NumberFormatter initFormatter() {
		NumberFormat numberFormat = NumberFormat.getInstance(new Locale("en"));
		numberFormat.setMaximumFractionDigits(NR_OF_FRACTION_DIGITS);
		numberFormat.setMinimumFractionDigits(0);
		numberFormat.setGroupingUsed(false);
		
		NumberFormatter numberFormatter = new NumberFormatter(numberFormat);
		numberFormatter.setCommitsOnValidEdit(true);
		numberFormatter.setMinimum(new Double(0));
		numberFormatter.setAllowsInvalid(false);
		
		return numberFormatter;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {		
		frame = new JFrame();
		frame.setTitle("Convertor Valutar");
		frame.setBounds(100, 100, 939, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setMnemonic(KeyEvent.VK_F);
		menuBar.add(mnFile);
		
		mntmExit = new JMenuItem("Ie\u015Fire");
		mntmExit.setMnemonic(KeyEvent.VK_I);
		mnFile.add(mntmExit);
		
		JMenu mnOptiuni = new JMenu("Op\u0163iuni");
		mnOptiuni.setMnemonic(KeyEvent.VK_O);
		menuBar.add(mnOptiuni);
		
		JMenu mnAjutor = new JMenu("Ajutor");
		mnAjutor.setMnemonic(KeyEvent.VK_A);
		menuBar.add(mnAjutor);
		
		mntmGuide = new JMenuItem("Ghid utilizare");
		mntmGuide.setMnemonic(KeyEvent.VK_G);
		mnAjutor.add(mntmGuide);
		
		mntmAbout = new JMenuItem("Despre");
		mntmAbout.setMnemonic(KeyEvent.VK_D);
		mnAjutor.add(mntmAbout);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Data cursului", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panel.setBounds(208, 17, 116, 60);
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblData = new JLabel("14 August 2011");
		lblData.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblData);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(new TitledBorder(null, "Schimb\u0103", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		scrollPane.setBounds(25, 89, 230, 184);
		frame.getContentPane().add(scrollPane);
		
		lsFrom = new JList();
		scrollPane.setViewportView(lsFrom);
		lsFrom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBorder(new TitledBorder(null, "\u00EEn", TitledBorder.CENTER, TitledBorder.ABOVE_TOP, null, new Color(59, 59, 59)));
		scrollPane_1.setBounds(267, 90, 230, 184);
		frame.getContentPane().add(scrollPane_1);
		
		lsTo = new JList();
		scrollPane_1.setViewportView(lsTo);
		lsTo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		lblFromCurrency = new JLabel("EUR");
		lblFromCurrency.setVerticalAlignment(SwingConstants.BOTTOM);
		lblFromCurrency.setBounds(853, 65, 55, 16);
		frame.getContentPane().add(lblFromCurrency);
		
		JLabel lblSum = new JLabel("Sum\u0103");
		lblSum.setBounds(637, 65, 55, 16);
		frame.getContentPane().add(lblSum);
		
		JLabel lblRate1 = new JLabel("Rat\u0103 de conversie");
		lblRate1.setBounds(579, 101, 112, 16);
		frame.getContentPane().add(lblRate1);
		
		JLabel lblRate2 = new JLabel("proprie");
		lblRate2.setBounds(636, 118, 55, 16);
		frame.getContentPane().add(lblRate2);
		
		btnReverse = new JButton("Inverseaz\u0103");
		btnReverse.setMnemonic(KeyEvent.VK_S);
		btnReverse.setBounds(215, 285, 102, 28);
		frame.getContentPane().add(btnReverse);
		
		lblTva = new JLabel("tva");
		lblTva.setHorizontalAlignment(SwingConstants.CENTER);
		lblTva.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblTva.setBounds(723, 222, 105, 16);
		frame.getContentPane().add(lblTva);
		
		lblResultPlusTva = new JLabel("rez + tva");
		lblResultPlusTva.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblResultPlusTva.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultPlusTva.setBounds(723, 252, 105, 16);
		frame.getContentPane().add(lblResultPlusTva);
		
		lblResult = new JLabel("rez");
		lblResult.setHorizontalAlignment(SwingConstants.CENTER);
		lblResult.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		lblResult.setBounds(723, 298, 105, 16);
		frame.getContentPane().add(lblResult);
		
		JLabel lblTvaDescriptor = new JLabel("TVA (XX%)");
		lblTvaDescriptor.setLabelFor(lblTva);
		lblTvaDescriptor.setText("TVA ("
				+ new Integer((int) (ConvValutarModel.VAT * 100)) + "%)");
		lblTvaDescriptor.setBounds(625, 222, 67, 16);
		frame.getContentPane().add(lblTvaDescriptor);
		
		JLabel lblResultPlusTvaDescriptor = new JLabel("Rezultat + TVA");
		lblResultPlusTvaDescriptor.setLabelFor(lblResultPlusTva);
		lblResultPlusTvaDescriptor.setBounds(608, 252, 84, 16);
		frame.getContentPane().add(lblResultPlusTvaDescriptor);
		
		JLabel lblResultDescriptor = new JLabel("Rezultat");
		lblResultDescriptor.setForeground(Color.RED);
		lblResultDescriptor.setOpaque(true);
		lblResultDescriptor.setLabelFor(lblResult);
		lblResultDescriptor.setBounds(637, 298, 55, 16);
		frame.getContentPane().add(lblResultDescriptor);
		
		lblToCurrency = new JLabel("LEI");
		lblToCurrency.setBounds(853, 298, 55, 16);
		frame.getContentPane().add(lblToCurrency);
		
		txtSum = new JFormattedTextField(numberFormatter);
		txtSum.setHorizontalAlignment(SwingConstants.CENTER);
		txtSum.setValue(new Double(1));
		txtSum.setBounds(723, 59, 105, 28);
		txtSum.addFocusListener(new FormattedTextFieldFocusListener());
		frame.getContentPane().add(txtSum);
		
		txtRate = new JFormattedTextField(numberFormatter);
		txtRate.setHorizontalAlignment(SwingConstants.CENTER);
		txtRate.setValue(new Double(0));
		txtRate.setBounds(723, 105, 105, 28);
		txtRate.addFocusListener(new FormattedTextFieldFocusListener());
		frame.getContentPane().add(txtRate);
		
	}

	@Override
	public void update(Model m, Object obj) {
		final ConvValutarModel myModel = (ConvValutarModel) m;
		final HashMap<String, String> labelsTextMap;

		final Currency[] currenciesArray = myModel.getXmlInfo().getCurrenciesArray();

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
				lblData.setText(lbDateText);
			}

			private void updateResultLabels(HashMap<String, String> labelsText) {
				lblResult.setText(labelsText.get("lbResultText").toString());
				lblTva.setText(labelsText.get("lbVatText").toString());
				lblResultPlusTva.setText(labelsText.get("lbResultAndVatText")
						.toString());
				lblFromCurrency.setText(labelsText.get("lbFromCurrencyText")
						.toString());
				lblToCurrency.setText(labelsText.get("lbToCurrencyText")
						.toString());
			}

		});
		
	}
	
	private HashMap<String, String> generateLabelsTextMapFromModel(final ConvValutarModel myModel) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		map.put("lbResultText",
				String.valueOf(numberFormatter.getFormat().format(myModel.getResult())));
		map.put("lbVatText",
				String.valueOf(numberFormatter.getFormat().format(myModel.getVat())));
		map.put("lbResultAndVatText",
				String.valueOf(numberFormatter.getFormat().format(myModel.getResultAndVat())));
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
		boolean shouldScroll = false;
		list.setSelectedValue(new Currency(currencyShortName), shouldScroll);
	}
	
	
	
	/**
	 * Used to call <code>selectAll()</code> on the
	 * <code>JFormattedTextField</code>'s when they acquire keyboard focus
	 * 
	 * @author VlaD
	 * 
	 */
	private class FormattedTextFieldFocusListener extends FocusAdapter{

		@Override
		public void focusGained(final FocusEvent e) {

			SwingUtilities.invokeLater(new Runnable() {

				@Override
				public void run() {
					((JFormattedTextField) (e.getSource())).selectAll();
				}
			});

		}
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public JLabel getLblData() {
		return lblData;
	}

	public JList getLsTo() {
		return lsTo;
	}

	public JList getLsFrom() {
		return lsFrom;
	}

	public JFormattedTextField getTxtSum() {
		return txtSum;
	}

	public JFormattedTextField getTxtRate() {
		return txtRate;
	}

	public JMenuItem getMntmExit() {
		return mntmExit;
	}

	public JMenuItem getMntmGuide() {
		return mntmGuide;
	}

	public JMenuItem getMntmAbout() {
		return mntmAbout;
	}

	public JButton getBtnSwitch() {
		return btnReverse;
	}

	public JLabel getLblResult() {
		return lblResult;
	}

	public JLabel getLblResultPlusTva() {
		return lblResultPlusTva;
	}

	public JLabel getLblTva() {
		return lblTva;
	}

	public JLabel getLblFromCurrency() {
		return lblFromCurrency;
	}

	public JLabel getLblToCurrency() {
		return lblToCurrency;
	}
}
