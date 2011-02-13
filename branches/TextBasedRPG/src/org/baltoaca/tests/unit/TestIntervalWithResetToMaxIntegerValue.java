package org.baltoaca.tests.unit;

import static org.junit.Assert.*;

import org.baltoaca.stats.IntervalWithResetToMaxIntegerValue;
import org.junit.Test;

public class TestIntervalWithResetToMaxIntegerValue {

	@Test
	public void testSubtractOverZero() {
		IntervalWithResetToMaxIntegerValue value = new IntervalWithResetToMaxIntegerValue(
				30);
		
		value.substractFromValue(20);
		
		assertEquals(10, value.getCurrentValue());
	}
	
	@Test
	public void testSubtractUnderZero(){
		IntervalWithResetToMaxIntegerValue value = new IntervalWithResetToMaxIntegerValue(
				30);
		
		value.substractFromValue(40);
		
		assertEquals(0, value.getCurrentValue());
	}
	
	@Test
	public void testReset(){
		IntervalWithResetToMaxIntegerValue value = new IntervalWithResetToMaxIntegerValue(
				30, 15);
		
		value.resetToMaxValue();
		
		assertEquals(30, value.getCurrentValue());
	}
	
}
