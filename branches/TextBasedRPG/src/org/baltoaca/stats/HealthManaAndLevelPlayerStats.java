package org.baltoaca.stats;


public class HealthManaAndLevelPlayerStats {
	IntervalIntegerValue health;
	IntervalIntegerValue mana;
	Level level;
	
	public HealthManaAndLevelPlayerStats(int maxHealth, int maxMana, int experience){
		health = new IntervalIntegerValue(maxHealth);
		mana = new IntervalIntegerValue(maxMana);
		level = new Level(experience);
	}
	
	public HealthManaAndLevelPlayerStats(int maxHealth,int currentHealth, int maxMana, int currentMana, int experience){
		health = new IntervalIntegerValue(maxHealth, currentHealth);
		mana = new IntervalIntegerValue(maxMana, currentMana);
		level = new Level(experience);
	}
	
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
	public boolean isLeveledUp(){
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
