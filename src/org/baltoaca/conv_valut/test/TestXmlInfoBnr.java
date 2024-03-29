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
		Currency[] currencies = info.getCurrenciesArray();
		String[] currenciesStrings = new String[currencies.length];

		for (int i = 0; i < currenciesStrings.length; i++) {
			currenciesStrings[i] = currencies[i].toString();
		}
		
		assertArrayEquals(
				new String[] { "RON - Leul rom�nesc", "EUR - Euro",
						"USD - Dolarul SUA", "AED - Dirhamul Emiratelor Arabe",
						"AUD - Dolarul australian", "BGN - Leva bulg�reasc�",
						"BRL - Realul brazilian", "CAD - Dolarul canadian",
						"CHF - Francul elve�ian",
						"CNY - Renminbi-ul chinezesc", "CZK - Coroana ceh�",
						"DKK - Coroana danez�", "EGP - Lira egiptean�",
						"GBP - Lira sterlin�", "100HUF - Forin�i maghiari",
						"INR - Rupia indian�", "100JPY - Yeni japonezi",
						"100KRW - Woni sud-coreeni", "MDL - Leul moldovenesc",
						"MXN - Peso-ul mexican", "NOK - Coroana norvegian�",
						"NZD - Dolarul neo-zeelandez", "PLN - Zlotul polonez",
						"RSD - Dinarul sarbesc", "RUB - Rubla ruseasc�",
						"SEK - Coroana suedez�", "TRY - Noua lir� turceasc�",
						"UAH - Hryvna ucrainean�", "XAU - Gramul de aur",
						"XDR - DST", "ZAR - Randul sud-african" },
				currenciesStrings);
	}
}
