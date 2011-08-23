package org.baltoaca.conv_valut.thread;


import java.awt.EventQueue;
import java.io.IOException;
import java.net.URL;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.xml.parsers.ParserConfigurationException;

import org.baltoaca.conv_valut.gui.Loader;
import org.baltoaca.conv_valut.gui.designer.MainFrame;
import org.baltoaca.conv_valut.mvc.ConvValutarController;
import org.baltoaca.conv_valut.mvc.ConvValutarModel;
import org.baltoaca.conv_valut.xml.XmlInfoBnr;
import org.baltoaca.conv_valut.xml.XmlSource;
import org.xml.sax.SAXException;

public class Main {

	public static final Locale locale = new Locale("ro");
	
	public static void main(String[] args) {
		setLookAndFeel();
		
		Loader loader;
		ConvValutarModel model = null;
		final MainFrame window = new MainFrame();
		
		loader = new Loader(window.getFrame(), "Citire date", "", 0, 6);
		loader.next();
		
		XmlInfoBnr xmlInfoBnr = null;
		XmlSource xmlSource = null;
		try {
			
			xmlSource = new XmlSource(new URL("http://www.bnro.ro/nbrfxrates.xml"),
			"Banca Nationala a Romaniei");
			
			loader.next();
			xmlInfoBnr = new XmlInfoBnr(xmlSource);
			loader.next();
			
			model = new ConvValutarModel(xmlInfoBnr);
			loader.next();
			model.addModelListener(window);
			loader.next();
			@SuppressWarnings("unused")
			ConvValutarController controller = new ConvValutarController(model,window);
			loader.next();
			window.update(model, null);
			loader.next();
			
			SwingUtilities.invokeLater(new Runnable() {
				@Override
				public void run() {
					selectDefaultsInJLists(window);
					
					window.getFrame().setVisible(true);
				}

				private void selectDefaultsInJLists(MainFrame window) {
					window.selectCurrencyInFromList("EUR");
					window.selectCurrencyInToList("RON");
				}


			});
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (SAXException e) {
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Nu s-a reusit stabilirea unei conexiuni la server:\n"+xmlSource,"Eroare",JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
			System.exit(0);
		}
		
		

	}
	
	private static void setLookAndFeel() {
		try {
			EventQueue.invokeAndWait(new Runnable() {
				
				@Override
				public void run() {
					try {
					    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
					        if ("Nimbus".equals(info.getName())) {
					            UIManager.setLookAndFeel(info.getClassName());
					            break;
					        }
					    }
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

}
