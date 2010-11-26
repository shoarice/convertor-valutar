package org.baltoaca.conv_valut.xml;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.SortedSet;

import javax.xml.parsers.ParserConfigurationException;

import org.baltoaca.conv_valut.computer.Currency;
import org.baltoaca.conv_valut.thread.Main;
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
	
	
	public Currency[] getCurrenciesArray(){
		Currency[] currenciesArray = new Currency[currencies.size()];
		return currencies.toArray(currenciesArray);
	}

	/**
	 * 
	 * @return The date field in a human-readable format
	 */
	public String dateToString() {
		DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG,Main.locale);
		return dateFormat.format(date.getTime());
	}

	protected void addBaseCurrencyIfNeeded(){
		Currency ron = new Currency("RON","Leul românesc", 1.0);
		
		if(!currencies.contains(ron)){
			currencies.add(ron);
		}
		

	}

}
