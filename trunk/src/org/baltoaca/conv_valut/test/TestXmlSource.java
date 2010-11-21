package org.baltoaca.conv_valut.test;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.baltoaca.conv_valut.xml.XmlSource;
import org.junit.Test;
import org.xml.sax.SAXException;


public class TestXmlSource{
	
	@Test
	public void test(){
		
		try{
			XmlSource bnr = new XmlSource(new URL("http://www.bnro.ro/nbrfxrates.xml"),
			"Banca Nationala Romana");
			
			assertEquals("DataSet",bnr.getParsedDocument().getChildNodes().item(0)
					.getNodeName());
			
		} catch (ParserConfigurationException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		} catch (SAXException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		} catch (IOException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		}
	}

}
