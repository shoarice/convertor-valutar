package org.baltoaca.conv_valut.test;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.baltoaca.conv_valut.gui.MainFrame;
import org.baltoaca.conv_valut.mvc.ConvValutarModel;
import org.baltoaca.conv_valut.mvc.ModelListener;
import org.baltoaca.conv_valut.xml.XmlInfoBnr;
import org.baltoaca.conv_valut.xml.XmlSource;
import org.xml.sax.SAXException;

public class ConvValutarModelTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ConvValutarModel model = null;
		ModelListener view = new MainFrame();
		try {
			model = new ConvValutarModel(new XmlInfoBnr(new XmlSource(
					new URL("http://www.bnro.ro/nbrfxrates.xml"),
					"Banca Nationala a Romaniei")));
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

		model.addModelListener(view);
		model.setResult(23.89);

	}
}
