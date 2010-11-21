package org.baltoaca.conv_valut.test;

import static org.junit.Assert.*;

import java.text.NumberFormat;
import java.util.Locale;

import org.junit.Test;


public class TestFormatterLearning {
	
	@Test
	public void test(){
		
		Locale locale = new Locale("en");
		NumberFormat format = NumberFormat.getInstance(locale);
		
		format.setMaximumFractionDigits(2);
		format.setMinimumFractionDigits(2);
		
		assertEquals("12,345.00",format.format(12345));
	}

}
