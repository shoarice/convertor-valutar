package org.baltoaca.stats;

public class CorePlayerStats {
	
	/**
	 * Increases physical damage and maximum health
	 */
	IntervalWithResetToMaxIntegerValue strength;
	
	
	/**
	 * Increases magic damage and maximum mana
	 */
	IntervalWithResetToMaxIntegerValue intelligence;
	
	
	/**
	 * Increases chance to hit with all attacks and dodge chance
	 */
	IntervalWithResetToMaxIntegerValue dexterity;
	
	
	/**
	 * Plays a small part in any action taken in the game
	 */
	IntervalWithResetToMaxIntegerValue luck;
	
	public CorePlayerStats(int strength, int intelligence, int dexterity, int luck){
		this.strength = new IntervalWithResetToMaxIntegerValue(strength);
		this.intelligence = new IntervalWithResetToMaxIntegerValue(intelligence);
		this.dexterity = new IntervalWithResetToMaxIntegerValue(dexterity);
		this.luck = new IntervalWithResetToMaxIntegerValue(luck);
	}
	
	public int getStrength(){
		return strength.getCurrentValue();
	}
	
	public int getIntelligence(){
		return intelligence.getCurrentValue();
	}
	
	public int geDexterity(){
		return dexterity.getCurrentValue();
	}
	
	public int getLuck(){
		return luck.getCurrentValue();
	}
	
	public void lowerStrengthBy(int amount){
		strength.substractFromValue(amount);
	}
	
	public void lowerIntelligencehBy(int amount){
		intelligence.substractFromValue(amount);
	}
	
	public void lowerDexterityBy(int amount){
		dexterity.substractFromValue(amount);
	}
	
	public void lowerLuckBy(int amount){
		luck.substractFromValue(amount);
	}
	
	public void resetStrengthToMax(){
		strength.resetToMaxValue();
	}
	
	public void resetIntelligenceToMax(){
		intelligence.resetToMaxValue();
	}
	
	public void resetDexterityToMax(){
		dexterity.resetToMaxValue();
	}
	
	public void resetLuckToMax(){
		luck.resetToMaxValue();
	}
	
	
}
