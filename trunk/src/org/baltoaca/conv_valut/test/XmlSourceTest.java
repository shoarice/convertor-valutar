package org.baltoaca.conv_valut.test;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.baltoaca.conv_valut.xml.XmlSource;
import org.xml.sax.SAXException;

public class XmlSourceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			XmlSource bnr = new XmlSource(new URL("http://www.bnro.ro/nbrfxrates.xml"),
			"Banca Nationala Romana");
			System.out.println(bnr.getParsedDocument().getChildNodes().item(0)
					.getNodeName());
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

	}

}
