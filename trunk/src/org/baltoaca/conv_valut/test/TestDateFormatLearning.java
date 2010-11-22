package org.baltoaca.conv_valut.test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Locale;

import org.junit.Test;


public class TestDateFormatLearning {
	
	@Test
	public void test(){
		Calendar cal = Calendar.getInstance(new Locale("ro"));
		
		DateFormat time = DateFormat.getDateInstance(DateFormat.LONG,new Locale("ro"));
		System.out.println(time.format(cal.getTime()));
	}

}
