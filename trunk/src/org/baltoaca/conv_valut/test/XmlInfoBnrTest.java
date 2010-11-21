package org.baltoaca.conv_valut.test;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import javax.xml.parsers.ParserConfigurationException;
import org.baltoaca.conv_valut.xml.XmlInfoBnr;
import org.baltoaca.conv_valut.xml.XmlInformation;
import org.baltoaca.conv_valut.xml.XmlSource;
import org.xml.sax.SAXException;

public class XmlInfoBnrTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		XmlInformation info = null;
		try {
			info = new XmlInfoBnr(new XmlSource(
					new URL("http://www.bnro.ro/nbrfxrates.xml"),
					"Banca Nationala Romana"));
		} catch (ParserConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SAXException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			info.refreshData();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(info.getDate().get(Calendar.DATE));
		System.out.println(info.getDate().get(Calendar.MONTH) + 1);
		System.out.println(info.getDate().get(Calendar.YEAR));
		System.out.println(info.getDateString());
		System.out.println(info.getCurrencies());
	}

}
