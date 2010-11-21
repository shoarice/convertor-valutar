package org.baltoaca.conv_valut.thread;


import java.awt.Component;
import java.io.IOException;
import java.net.URL;

import javax.swing.SwingUtilities;
import javax.xml.parsers.ParserConfigurationException;

import org.baltoaca.conv_valut.gui.Loader;
import org.baltoaca.conv_valut.gui.MainFrame;
import org.baltoaca.conv_valut.mvc.ConvValutarController;
import org.baltoaca.conv_valut.mvc.ConvValutarModel;
import org.baltoaca.conv_valut.mvc.ModelListener;
import org.baltoaca.conv_valut.xml.XmlInfoBnr;
import org.baltoaca.conv_valut.xml.XmlSource;
import org.xml.sax.SAXException;

public class Main {

	
	public static void main(String[] args) {
		MainFrame.installLnF();

		Loader loader;
		ConvValutarModel model = null;
		final ModelListener view = new MainFrame();
		
		loader = new Loader((Component) view, "Citire date", "", 0, 6);
		loader.next();
		
		
		
		XmlInfoBnr xmlInfoBnr = null;
		try {
			
			XmlSource xmlSource = new XmlSource(new URL("http://www.bnro.ro/nbrfxrates.xml"),
			"Banca Nationala a Romaniei");
			
			loader.next();
			xmlInfoBnr = new XmlInfoBnr(xmlSource);
			loader.next();
			
			model = new ConvValutarModel(xmlInfoBnr);
			loader.next();
			model.addModelListener(view);
			loader.next();
			@SuppressWarnings("unused")
			ConvValutarController controller = new ConvValutarController(model,view);
			loader.next();
			view.update(model, null);
			loader.next();
			
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {

					MainFrame frame = (MainFrame) view;

					selectDefaultsInJLists(frame);
					setFrameDefaults(frame);

				}

				private void selectDefaultsInJLists(MainFrame frame) {
					frame.selectCurrencyInFromList("EUR");
					frame.selectCurrencyInToList("RON");
				}
				
				private void setFrameDefaults(MainFrame frame) {
					frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
					frame.setTitle("Convertor Valutar");
					frame.getContentPane().setPreferredSize(frame.getSize());
					frame.pack();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				}


			});
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(0);
		}
		
		

	}


}
