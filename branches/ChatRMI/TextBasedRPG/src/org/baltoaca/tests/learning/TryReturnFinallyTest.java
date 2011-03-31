package org.baltoaca.tests.learning;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class TryReturnFinallyTest {
	TestClass testClass;
	@Before
	public void setUp() throws Exception {
		 testClass = new TestClass();
		 testClass.flag = true;
	}
	
	@Test
	public void test(){
		boolean flag = testClass.getFlagAndResetFlagAfter();
		
		assertEquals(true,flag);
		assertEquals(false,testClass.flag);
	}

}

class TestClass{
	
	public boolean flag = false;
	
	public boolean getFlagAndResetFlagAfter(){
		try {
			return flag;
		} finally{
			flag = false;
		}
	}
	
}
