package org.baltoaca.conv_valut.test;

import java.io.IOException;
import java.net.URL;

import javax.swing.SwingUtilities;
import javax.xml.parsers.ParserConfigurationException;

import org.baltoaca.conv_valut.gui.MainFrame;
import org.baltoaca.conv_valut.mvc.ConvValutarController;
import org.baltoaca.conv_valut.mvc.ConvValutarModel;
import org.baltoaca.conv_valut.mvc.ModelListener;
import org.baltoaca.conv_valut.xml.XmlInfoBnr;
import org.baltoaca.conv_valut.xml.XmlSource;
import org.xml.sax.SAXException;

public class ConvValutarControllerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MainFrame.installLnF();
		ConvValutarModel model = null;
		final ModelListener view = new MainFrame();

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

		@SuppressWarnings("unused")
		ConvValutarController controller = new ConvValutarController(model,
				view);
		view.update(model, null);

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				MainFrame frame = (MainFrame) view;

				frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
				frame.setTitle("MainFrame");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		});
	}

}
