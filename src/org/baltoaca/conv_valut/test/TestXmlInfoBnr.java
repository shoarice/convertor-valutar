package org.baltoaca.conv_valut.test;

import static org.junit.Assert.assertArrayEquals;

import java.io.IOException;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.baltoaca.conv_valut.computer.Currency;
import org.baltoaca.conv_valut.xml.XmlInfoBnr;
import org.baltoaca.conv_valut.xml.XmlInformation;
import org.baltoaca.conv_valut.xml.XmlSource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

public class TestXmlInfoBnr {
	private static XmlInformation info;

	@BeforeClass
	public static void beforeClass() {

		try {

			info = new XmlInfoBnr(new XmlSource(new URL(
					"http://www.bnro.ro/nbrfxrates.xml"),
					"Banca Nationala Romana"));

			info.refreshData();

		} catch (ParserConfigurationException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		} catch (SAXException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		} catch (IOException e) {
			TestUtils.failBecauseOfUnexpectedExeption(e);
		}
	}

	@Test
	public void testCurrencies() {
		Currency[] currencies = info.getCurrencies().toArray(new Currency[0]);
		String[] currenciesStrings = new String[currencies.length];

		for (int i = 0; i < currenciesStrings.length; i++) {
			currenciesStrings[i] = currencies[i].toString();
		}
		
		assertArrayEquals(
				new String[] { "RON - Leul românesc", "EUR - Euro",
						"USD - Dolarul SUA", "AED - Dirhamul Emiratelor Arabe",
						"AUD - Dolarul australian", "BGN - Leva bulgãreascã",
						"BRL - Realul brazilian", "CAD - Dolarul canadian",
						"CHF - Francul elveþian",
						"CNY - Renminbi-ul chinezesc", "CZK - Coroana cehã",
						"DKK - Coroana danezã", "EGP - Lira egipteanã",
						"GBP - Lira sterlinã", "100HUF - Forinþi maghiari",
						"INR - Rupia indianã", "100JPY - Yeni japonezi",
						"100KRW - Woni sud-coreeni", "MDL - Leul moldovenesc",
						"MXN - Peso-ul mexican", "NOK - Coroana norvegianã",
						"NZD - Dolarul neo-zeelandez", "PLN - Zlotul polonez",
						"RSD - Dinarul sarbesc", "RUB - Rubla ruseascã",
						"SEK - Coroana suedezã", "TRY - Noua lirã turceascã",
						"UAH - Hryvna ucraineanã", "XAU - Gramul de aur",
						"XDR - DST", "ZAR - Randul sud-african" },
				currenciesStrings);
	}
}
