package org.baltoaca.conv_valut.test;

import static org.junit.Assert.assertEquals;

import org.baltoaca.conv_valut.computer.Currency;
import org.junit.BeforeClass;
import org.junit.Test;


public class TestCurrency{
	
	private static Currency currencyDolar;
	private static Currency currencyEuroWithMultiplier;

	@BeforeClass
	public static void beforeClass(){
		currencyDolar = new Currency("USD","Dolarul american", 2.34);
		currencyEuroWithMultiplier = new Currency("EUR","Euro",4.1, 100);
	}
	
	@Test
	public void testToString(){

		assertEquals("USD - Dolarul american",currencyDolar.toString());
		assertEquals("100EUR - Euro", currencyEuroWithMultiplier.toString());

	}
	
	@Test
	public void testHasMultiplier(){
		assertEquals(true,currencyEuroWithMultiplier.hasMultiplier());
		assertEquals(false,currencyDolar.hasMultiplier());
	}

}
