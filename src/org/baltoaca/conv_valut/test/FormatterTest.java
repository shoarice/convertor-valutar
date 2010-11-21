package org.baltoaca.conv_valut.test;

import java.text.NumberFormat;
import java.util.Locale;

public class FormatterTest {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) {
		Locale locale = new Locale("en");
		NumberFormat format = NumberFormat.getInstance(locale);
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(2);
		System.out.println(format.format(12345));
	}

}
