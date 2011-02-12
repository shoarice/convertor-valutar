package org.baltoaca.stats;


public class PlayerStats {
	IntervalIntegerValue health;
	IntervalIntegerValue mana;
	Level level;
	
	public int getMaxHealth(){
		return health.getMaxValue();
	}
	
	public int getCurrentHealth(){
		return health.getCurrentValue();
	}
	
	public boolean isHealthZero(){
		return health.isZero();
	}
	
	public int getMaxMana(){
		return health.getMaxValue();
	}
	
	public int getCurrentMana(){
		return health.getCurrentValue();
	}
	
	public boolean isManaZero(){
		return health.isZero();
	}
	
	/**
	 * Resets the level up flag when called
	 */
	public boolean levelUp(){
		return level.isLeveledUp();
	}
	
	public int getExperience(){
		return level.getExperience();
	}
	
	public void addExperience(int amount){
		level.addExperience(amount);
	}
	
	public int getLevel(){
		return level.getLevel();
	}

}
