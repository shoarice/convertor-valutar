package org.baltoaca.conv_valut.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestStringLearning {
	
	@Test
	public void test(){
		String str="";
		
		addStringToString(str,"x");
		
		assertEquals("",str);
	}

	private void addStringToString(String str, String string) {
		str+=string;
	}
	

}
