package org.baltoaca.conv_valut.test.suites;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.SwingUtilities;
import javax.xml.parsers.ParserConfigurationException;

import org.baltoaca.conv_valut.computer.Currency;
import org.baltoaca.conv_valut.gui.designer.MainFrame;
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
	private static MainFrame window;
	
	private static ConvValutarModel model;
	private static XmlInfoBnr xmlInfoBnr;
	private static XmlSource xmlSource;
	
	private static Currency[] currencyArray;
	
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
		
		currencyArray = xmlInfoBnr.getCurrenciesArray();
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

				window = (MainFrame) view;

				selectEurAndRon();

				window.getFrame().setVisible(true);

			}
			
			public void selectEurAndRon() {
				window.selectCurrencyInFromList("EUR");
				window.selectCurrencyInToList("RON");
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
		window.selectCurrencyInFromList("EUR");
		window.selectCurrencyInToList("RON");
	}
	
	@Test
	public void testResultAllCurrenciesToBaseCurrency() throws InterruptedException{
		Double result = 0.0;
		Currency[] currencySet = xmlInfoBnr.getCurrenciesArray();
		
		for (Currency currency : currencySet) {
			window.selectCurrencyInFromList(currency.getShortName());
			waitABit();
			result = currency.getRate();
			
			assertEquals(result,Double.parseDouble(window.getLblResult().getText()),0.01);
		}
		
	}
	
	@Test
	public void testLabelAllCurrenciesToBaseCurrency() throws InterruptedException{
		
		for (Currency currency : currencyArray) {
			window.selectCurrencyInFromList(currency.getShortName());
			waitABit();
			
			assertEquals(currency.getShortName(),window.getLblFromCurrency().getText());
		}
		
	}
	
	
	@Test
	public void testResultAndVatAllCurrenciesToBaseCurrency() throws InterruptedException{
		Double result = 0.0;
		
		for (Currency currency : currencyArray) {
			window.selectCurrencyInFromList(currency.getShortName());
			waitABit();
			result = currency.getRate()*(1+ConvValutarModel.VAT);
			
			assertEquals(result,Double.parseDouble(window.getLblResultPlusTva().getText()),0.01);
		}
}


	
	@Test
	public void testVatAllCurrenciesToBaseCurrency() throws InterruptedException{
		Double result = 0.0;
		
		for (Currency currency : currencyArray) {
			window.selectCurrencyInFromList(currency.getShortName());
			waitABit();
			result = currency.getRate()*ConvValutarModel.VAT;
			
			assertEquals(result,Double.parseDouble(window.getLblTva().getText()),0.01);
		}
	}
	
	private void waitABit() throws InterruptedException {
		Thread.sleep(50);
	}
	

}
