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
	
	

}
