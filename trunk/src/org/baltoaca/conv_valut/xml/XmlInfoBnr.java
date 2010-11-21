package org.baltoaca.conv_valut.xml;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;

import org.baltoaca.conv_valut.computer.Currency;
import org.baltoaca.conv_valut.computer.CurrencyBnrComparator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XmlInfoBnr extends XmlInformation {

	private XmlSource currencyFullNameSource;

	public XmlInfoBnr(XmlSource origin) throws ParserConfigurationException, SAXException, IOException {
		super(origin);
		currencyFullNameSource = new XmlSource(getClass().getClassLoader().getResource("fullCurrNames.xml"),
				"ISO4217");
		refreshData();
	}

	@Override
	public void refreshData() throws ParserConfigurationException,
			SAXException, IOException {
		currencies = new TreeSet<Currency>(new CurrencyBnrComparator());
		
		Document doc = origin.getParsedDocument();
		readCurrencies(doc);
		addBaseCurrency();
		
		date = readDate(doc);
	}

	/**
	 * 
	 * @param doc
	 *            Parsed XML file
	 * @return A Collection<Currency> object containing the currencies parsed
	 *         from the xml file
	 * @see Currency
	 */
	private SortedSet<Currency> readCurrencies(Document doc) {
		
		try {
			NodeList rateNodes = parseRateNodes(doc);
			int nrOfRateNodes = rateNodes.getLength();
			
			for (int i = 0; i < nrOfRateNodes; i++) {
				Element e = getElementFromNode(i, rateNodes);
	
				Currency parsedCurrency = parseCurrencyFromElement(e);				
				currencies.add(parsedCurrency);
				
			}
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Caca", "caca2", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Caca", "caca2", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			JOptionPane.showMessageDialog(null, "Caca", "caca2", JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}

		return currencies;
	}

	private NodeList parseRateNodes(Document doc) {
		NodeList rateNodes = parseNodesWithTagName("Rate",doc);
		return rateNodes;
	}

	private Element getElementFromNode(int i, NodeList rateNodes) {
		return (Element) rateNodes.item(i);
	}

	private Currency parseCurrencyFromElement(Element e)
			throws ParserConfigurationException, SAXException, IOException {
		
		Currency parsedCurrency;
		
		if (elementHasMultiplier(e)) {
			parsedCurrency = new Currency(parseCurrencyShortName(e),parseCurrencyFullName(e), parseRate(e),parseMultiplier(e));
		} else {
			parsedCurrency = new Currency(parseCurrencyShortName(e),parseCurrencyFullName(e), parseRate(e));
		}
		return parsedCurrency;
	}

	
	private boolean elementHasMultiplier(Element e) {
		return !e.getAttribute("multiplier").isEmpty();
	}

	private String parseCurrencyShortName(Element e) {
		return e.getAttribute("currency");
	}
	private String parseCurrencyFullName(Element e) throws ParserConfigurationException, SAXException, IOException {
		Document currencyFullNameDoc = currencyFullNameSource.getParsedDocument();
		return getFullNameOfCurrency(parseCurrencyShortName(e),currencyFullNameDoc);
	}
	private double parseRate(Element e) {
		return Double.parseDouble(e.getChildNodes().item(0).getNodeValue());
	}
	private double parseMultiplier(Element e) {
		return Double.parseDouble(e.getAttribute("multiplier"));
	}





	private String getFullNameOfCurrency(String currencyShortName, Document doc) {
		NodeList currencyNodes = parseCurrencyNodes(doc);

		for (int i = 0; i < currencyNodes.getLength(); i++) {
			Element e = getElementFromNode(i, currencyNodes);
			
			//TODO refactor down
			if (e.getElementsByTagName("iso4217").item(0).getChildNodes().item(0).getNodeValue().equals(currencyShortName)) {
				
				return e.getElementsByTagName("fullName").item(0).getChildNodes().item(0).getNodeValue();
			}
		}

		return null;
	}

	private NodeList parseCurrencyNodes(Document doc) {
		NodeList currencyNodes = parseNodesWithTagName("currency", doc);
		return currencyNodes;
	}

	/**
	 * Reads the date from the DOM enabled Document
	 * 
	 * @param doc
	 *            Parsed XML file
	 * @return A Calendar object set to the read date
	 */
	private Calendar readDate(Document doc) {
		Date formattedDate=null;
		
		String dateParsedFromXml = parseDateFromXml(doc);
		
		try {
			formattedDate = formatDate(dateParsedFromXml);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(formattedDate);
		return calendar;
	}

	private Date formatDate(String dateParsedFromXml) throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("y'-'M'-'d");
		Date formattedDate = dateFormat.parse(dateParsedFromXml);
		return formattedDate;
	}

	private String parseDateFromXml(Document doc) {
		Element dateElement = (Element) doc.getElementsByTagName("Cube").item(0);
		return dateElement.getAttribute("date");
	}
	
	private NodeList parseNodesWithTagName(String tagName, Document doc){
		return doc.getElementsByTagName(tagName);
	}
}
