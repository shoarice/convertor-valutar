package org.baltoaca.conv_valut.test;

import org.baltoaca.conv_valut.computer.Currency;

public class CurrencyTest {

	public static void main(String args[]) {

		Currency c1 = new Currency("USD","Dolarul american", 2.34);
		Currency c2 = new Currency("EUR","Euro",4.1, 100);

		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c2.hasMultiplier());
		System.out.println(c1.hasMultiplier());
	}

}
