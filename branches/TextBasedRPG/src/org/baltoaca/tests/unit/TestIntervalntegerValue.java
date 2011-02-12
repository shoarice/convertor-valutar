package org.baltoaca.tests.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.baltoaca.stats.IntervalIntegerValue;
import org.junit.Test;

public class TestIntervalntegerValue {
	IntervalIntegerValue value;
	
	@Test
	public void testAddUnderLimit(){
		value = new IntervalIntegerValue(30, 20);
		
		value.addToValue(5);
		
		assertEquals(25,value.getCurrentValue());
	}
	
	@Test
	public void testAddAtLimit(){
		value = new IntervalIntegerValue(30, 25);
		
		value.addToValue(5);
		
		assertEquals(30, value.getCurrentValue());
	}
	
	@Test
	public void testAddOverLimit(){
		value = new IntervalIntegerValue(30, 25);
		
		value.addToValue(10);
		
		assertEquals(30, value.getCurrentValue());
	}
	
	@Test
	public void testSubtractOverZero(){
		value = new IntervalIntegerValue(30);
		
		value.substractFromValue(10);
		
		assertEquals(20, value.getCurrentValue());
	}
	
	@Test
	public void testSubtractAtZero(){
		value = new IntervalIntegerValue(30);
		
		value.substractFromValue(30);
		
		assertEquals(0, value.getCurrentValue());
	}
	
	@Test
	public void testSubtractUnderZero(){
		value = new IntervalIntegerValue(30);
		
		value.substractFromValue(40);
		
		assertEquals(0, value.getCurrentValue());
	}
	
	@Test
	public void testZeroFlag(){
		value = new IntervalIntegerValue(30);
		
		value.substractFromValue(30);
		
		assertTrue(value.isZero());
	}
}
