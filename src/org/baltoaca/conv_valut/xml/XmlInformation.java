package org.baltoaca.conv_valut.xml;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

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
	protected List<Currency> currencies;
	protected XmlSource origin;

	public XmlInformation(XmlSource origin) {
		this.origin = origin;

	}

	/**
	 * Reads the data from the origin and stores it in class members
	 * 
	 * @throws IOException
	 * @throws SAXException
	 * @throws ParserConfigurationException
	 */
	public void refreshData() throws ParserConfigurationException,
			SAXException, IOException {
	}

	public List<Currency> getCurrencies() {
		return currencies;
	}

	public Calendar getDate() {
		return date;
	}

	/**
	 * 
	 * @return The date field in a human-readable format
	 */
	public String getDateString() {
		String str = "";
		str += date.get(Calendar.DATE);
		str += " ";
		switch (date.get(Calendar.MONTH)) {
		case 0:
			str += "Ianuarie";
			break;
		case 1:
			str += "Februarie";
			break;
		case 2:
			str += "Martie";
			break;
		case 3:
			str += "Aprilie";
			break;
		case 4:
			str += "Mai";
			break;
		case 5:
			str += "Iunie";
			break;
		case 6:
			str += "Iulie";
			break;
		case 7:
			str += "August";
			break;
		case 8:
			str += "Septembrie";
			break;
		case 9:
			str += "Octombrie";
			break;
		case 10:
			str += "Noiembrie";
			break;
		case 11:
			str += "Decembrie";
			break;
		default:
			str += "N/A";
			break;
		}
		str += " ";
		str += date.get(Calendar.YEAR);
		return str;
	}
	
	/**
	 * Arranges the Currencies list in a more user friendly way
	 */
	protected void arrangeCurrencies(){
		Currency ron = new Currency("RON","Leul românesc", 1.0);
		Currency eur = null,usd = null;
		boolean pass = false;
		//adds RON on top of the list
		if(!currencies.contains(ron)){
			currencies.add(0,ron);
		}
		for (Currency c : currencies) {
			if(c.getName().equals("EUR")){
				eur = c;
				pass = true;
			}
			if(pass == false && c.getName().equals("USD")){
				usd = c;
			}
			pass = false;
		}
		
		currencies.remove(eur);
		currencies.remove(usd);
		currencies.add(1, eur);
		currencies.add(2, usd);
	}

}
