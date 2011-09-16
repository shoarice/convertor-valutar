package org.baltoaca.stats;

/**
 * A class that represents an integer
 * which can take values in the interval
 * [0,MaxValue]
 * @author VlaD
 *
 */
public class IntervalIntegerValue {
	private int maxValue;
	private int currentValue;
	
	public IntervalIntegerValue(int maxValue){
		this.maxValue = maxValue;
		currentValue = maxValue;
	}
	
	public IntervalIntegerValue(int maxValue, int currentValue){
		this.maxValue = maxValue;
		this.currentValue = currentValue;
	}
	
	public void addToValue(int amount){
		int tempValue = currentValue + amount;
		
		if(tempValue > maxValue)
			currentValue = maxValue;
		else
			currentValue = tempValue;
	}
	
	public void substractFromValue(int amount){
		int tempValue = currentValue - amount;
		
		if(tempValue < 0)
			currentValue = 0;
		else
			currentValue = tempValue;
	}
	
	public boolean isZero(){
		if(currentValue == 0)
			return true;
		else
			return false;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public int getCurrentValue() {
		return currentValue;
	}
	
	
}
