package org.baltoaca.conv_valut.test.suites;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.SwingUtilities;
import javax.xml.parsers.ParserConfigurationException;

import org.baltoaca.conv_valut.gui.MainFrame;
import org.baltoaca.conv_valut.mvc.ConvValutarController;
import org.baltoaca.conv_valut.mvc.ConvValutarModel;
import org.baltoaca.conv_valut.mvc.ModelListener;
import org.baltoaca.conv_valut.test.TestUtils;
import org.baltoaca.conv_valut.xml.XmlInfoBnr;
import org.baltoaca.conv_valut.xml.XmlSource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

public class TestInputOutput {

	private final static ModelListener view = new MainFrame();
	private static MainFrame frame;
	
	private static ConvValutarModel model;
	private static XmlInfoBnr xmlInfoBnr;
	private static XmlSource xmlSource;

	@BeforeClass
	public static void before() {
		MainFrame.installLnF();
		try {
			
			initClassFields();

		} catch (ParserConfigurationException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		} catch (SAXException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		} catch (IOException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		}

		setUpMVC();
		startGUI();
	}
	
	private static void initClassFields() throws MalformedURLException,
	ParserConfigurationException, SAXException, IOException {
		xmlSource = new XmlSource(new URL("http://www.bnro.ro/nbrfxrates.xml"),
		"Banca Nationala a Romaniei");
		xmlInfoBnr = new XmlInfoBnr(xmlSource);
	}

	private static void setUpMVC() {
		model = new ConvValutarModel(xmlInfoBnr);
		model.addModelListener(view);
		
		@SuppressWarnings("unused")
		ConvValutarController controller = new ConvValutarController(model,
				view);
		
		view.update(model, null);
	}
	

	private static void startGUI() {
		
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {

				frame = (MainFrame) view;

				selectEurAndRon();
				
				frame.setDefaultCloseOperation(MainFrame.EXIT_ON_CLOSE);
				frame.setTitle("Convertor Valutar");
				frame.getContentPane().setPreferredSize(frame.getSize());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				

			}

			private void selectEurAndRon() {
				frame.getLsFrom().setSelectedIndex(1);
				frame.getLsTo().setSelectedIndex(0);
			}
		});
		
		//time for GUI to appear
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		}
	}



	
	@Test
	public void testResult(){
		Double result = xmlInfoBnr.getCurrencies().get(1).getRate();
		
		assertEquals(result,Double.parseDouble(frame.getLbResult().getText()),0.01);
	}
	
	@Test
	public void testResultAndVat(){
		Double result = xmlInfoBnr.getCurrencies().get(1).getRate()*(1+ConvValutarModel.VAT);
		
		assertEquals(result,Double.parseDouble(frame.getLbResultAndVat().getText()),0.01);
	}
	
	@Test
	public void testVat(){
		Double vat = xmlInfoBnr.getCurrencies().get(1).getRate()*ConvValutarModel.VAT;
		
		assertEquals(vat,Double.parseDouble(frame.getLbVat().getText()),0.01);
	}
	
	

}
