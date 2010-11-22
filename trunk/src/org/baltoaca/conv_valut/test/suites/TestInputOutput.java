package org.baltoaca.conv_valut.test.suites;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

import javax.swing.SwingUtilities;
import javax.xml.parsers.ParserConfigurationException;

import org.baltoaca.conv_valut.computer.Currency;
import org.baltoaca.conv_valut.gui.MainFrame;
import org.baltoaca.conv_valut.mvc.ConvValutarController;
import org.baltoaca.conv_valut.mvc.ConvValutarModel;
import org.baltoaca.conv_valut.mvc.ModelListener;
import org.baltoaca.conv_valut.test.TestUtils;
import org.baltoaca.conv_valut.xml.XmlInfoBnr;
import org.baltoaca.conv_valut.xml.XmlSource;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

public class TestInputOutput {

	private final static ModelListener view = new MainFrame();
	private static MainFrame frame;
	
	private static ConvValutarModel model;
	private static XmlInfoBnr xmlInfoBnr;
	private static XmlSource xmlSource;
	
	private static Set<Currency> currencySet;
	
	@BeforeClass
	public static void before() {
		try {
			
			initClassFields();
			setUpMVC();
			startGUI();
			
		} catch (ParserConfigurationException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		} catch (SAXException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		} catch (IOException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		} catch (Exception e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		}


	}
	
	private static void initClassFields() throws MalformedURLException,
	ParserConfigurationException, SAXException, IOException {
		xmlSource = new XmlSource(new URL("http://www.bnro.ro/nbrfxrates.xml"),
		"Banca Nationala a Romaniei");
		xmlInfoBnr = new XmlInfoBnr(xmlSource);
		
		currencySet = xmlInfoBnr.getCurrencies();
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
		MainFrame.installLnF();
		
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
			
			public void selectEurAndRon() {
				frame.selectCurrencyInFromList("EUR");
				frame.selectCurrencyInToList("RON");
			}


		});
		
		//time for GUI to appear
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		}
	}


	@Before
	public void selectEurAndRon() {
		frame.selectCurrencyInFromList("EUR");
		frame.selectCurrencyInToList("RON");
	}
	
	@Test
	public void testResultAllCurrenciesToBaseCurrency() throws InterruptedException{
		Double result = 0.0;
		Set<Currency> currencySet = xmlInfoBnr.getCurrencies();
		
		for (Currency currency : currencySet) {
			frame.selectCurrencyInFromList(currency.getShortName());
			waitABit();
			result = currency.getRate();
			
			assertEquals(result,Double.parseDouble(frame.getLbResult().getText()),0.01);
		}
		
	}
	
	@Test
	public void testLabelAllCurrenciesToBaseCurrency() throws InterruptedException{
		
		for (Currency currency : currencySet) {
			frame.selectCurrencyInFromList(currency.getShortName());
			waitABit();
			
			assertEquals(currency.getShortName(),frame.getLbFromCurrency().getText());
		}
		
	}
	
	
	@Test
	public void testResultAndVatAllCurrenciesToBaseCurrency() throws InterruptedException{
		Double result = 0.0;
		
		for (Currency currency : currencySet) {
			frame.selectCurrencyInFromList(currency.getShortName());
			waitABit();
			result = currency.getRate()*(1+ConvValutarModel.VAT);
			
			assertEquals(result,Double.parseDouble(frame.getLbResultAndVat().getText()),0.01);
		}
}


	
	@Test
	public void testVatAllCurrenciesToBaseCurrency() throws InterruptedException{
		Double result = 0.0;
		
		for (Currency currency : currencySet) {
			frame.selectCurrencyInFromList(currency.getShortName());
			waitABit();
			result = currency.getRate()*ConvValutarModel.VAT;
			
			assertEquals(result,Double.parseDouble(frame.getLbVat().getText()),0.01);
		}
	}
	
	private void waitABit() throws InterruptedException {
		Thread.sleep(50);
	}
	

}
