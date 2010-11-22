package org.baltoaca.conv_valut.xml;

import java.io.IOException;
import java.util.Calendar;
import java.util.SortedSet;

import javax.xml.parsers.ParserConfigurationException;

import org.baltoaca.conv_valut.computer.Currency;
import org.xml.sax.SAXException;

/**
 * Superclass for all the classes that hold the data retrieved from a XmlSource
 * 
 * @author VlaD
 * 
 */
public abstract class XmlInformation {

	protected Calendar date;
	protected SortedSet<Currency> currencies;
	protected XmlSource currencyRateSource;

	public XmlInformation(XmlSource origin) {
		currencyRateSource = origin;
	}

	/**
	 * Reads the data from the origin and stores it in class members
	 * 
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public abstract void refreshData() throws ParserConfigurationException,
			SAXException, IOException;

	public SortedSet<Currency> getCurrencies() {
		return currencies;
	}

	/**
	 * 
	 * @return The date field in a human-readable format
	 */
	public String dateToString() {
		StringBuilder dateStringBuilder = new StringBuilder();
		
		addDayOfMonthToStringBuilder(dateStringBuilder);
		addEmptySpaceToStringBuilder(dateStringBuilder);
		
		switch (getMonthNumber()) {
		case 0:
			addStringToStringBuilder("Ianuarie",dateStringBuilder);
			break;
		case 1:
			addStringToStringBuilder("Februarie",dateStringBuilder);
			break;
		case 2:
			addStringToStringBuilder("Martie",dateStringBuilder);
			break;
		case 3:
			addStringToStringBuilder("Aprilie",dateStringBuilder);
			break;
		case 4:
			addStringToStringBuilder("Mai",dateStringBuilder);
			break;
		case 5:
			addStringToStringBuilder("Iunie",dateStringBuilder);
			break;
		case 6:
			addStringToStringBuilder("Iulie",dateStringBuilder);
			break;
		case 7:
			addStringToStringBuilder("August",dateStringBuilder);
			break;
		case 8:
			addStringToStringBuilder("Septembrie",dateStringBuilder);
			break;
		case 9:
			addStringToStringBuilder("Octombrie",dateStringBuilder);
			break;
		case 10:
			addStringToStringBuilder("Noiembrie",dateStringBuilder);
			break;
		case 11:
			addStringToStringBuilder("Decembrie",dateStringBuilder);
			break;
		default:
			addStringToStringBuilder("N/A",dateStringBuilder);
			break;
		}
		addEmptySpaceToStringBuilder(dateStringBuilder);
		dateStringBuilder.append(date.get(Calendar.YEAR));
		return dateStringBuilder.toString();
	}

	private int getMonthNumber() {
		return date.get(Calendar.MONTH);
	}

	private void addEmptySpaceToStringBuilder(StringBuilder dateStringBuilder) {
		dateStringBuilder.append(" ");
	}
	
	private void addStringToStringBuilder(String string, StringBuilder dateStringBuilder) {
		dateStringBuilder.append(string);
	}

	private void addDayOfMonthToStringBuilder(StringBuilder dateString) {
		dateString.append(date.get(Calendar.DATE));
	}

	protected void addBaseCurrency(){
		Currency ron = new Currency("RON","Leul românesc", 1.0);
		
		if(!currencies.contains(ron)){
			currencies.add(ron);
		}
		

	}

}
