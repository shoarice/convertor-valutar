package org.baltoaca.stats;

/**
 * This class represents a value that can
 * take values in the interval [0, MaxValue]
 * but can be reset back to MaxValue
 * with a simple call to resetToMaxValue()
 * @author VlaD
 *
 */
public class IntervalWithResetToMaxIntegerValue {

	private int maxValue;
	private int currentValue;
	
	public IntervalWithResetToMaxIntegerValue(int maxValue) {
		this.maxValue = maxValue;
		currentValue = maxValue;
	}

	public IntervalWithResetToMaxIntegerValue(int maxValue, int currentValue) {
		this.maxValue = maxValue;
		this.currentValue = currentValue;
	}
	
	
	public void substractFromValue(int amount){
		int tempValue = currentValue - amount;
		
		if(tempValue < 0)
			currentValue = 0;
		else
			currentValue = tempValue;
	}
	
	public void resetToMaxValue(){
		currentValue = maxValue;
	}
	
	public boolean isMax(){
		if(maxValue == currentValue)
			return true;
		else
			return false;
	}

	public int getCurrentValue() {
		return currentValue;
	}
	
	

}
