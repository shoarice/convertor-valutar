package org.baltoaca.stats;

/**
 * This class represents the leveling system in the game.
 * 
 * When the client checks for levelUp() the level up flag will be
 * reset to false
 * 
 * @author VlaD
 *
 */
public class Level {
	private int experience;
	private int level = 1;
	private ExperienceToLevelMapper mapper;
	private boolean levelUp;
	
	public Level(){
		//TODO init mapper
	}
	
	public Level(int experience){
		this();
		this.experience = experience;
		updateLevelIfNeededAndSetLevelUpFlag();
		
		levelUp = false;
	}
	public void addExperience(int amount){
		experience+=amount;
		updateLevelIfNeededAndSetLevelUpFlag();
	}

	public int getExperience() {
		return experience;
	}
	private void updateLevelIfNeededAndSetLevelUpFlag() {
		int newLevel = mapper.getLevelFromExperience(experience);
		if(newLevel > level)
			this.level = newLevel;
		
		levelUp = true;
	}
	
	public int getLevel(){
		return level;
		
	}
	
	public boolean isLeveledUp(){
		return getLevelUpAndSetLevelUpFlag();
	}
	
	private boolean getLevelUpAndSetLevelUpFlag(){
		try{
			return levelUp;
		}finally{
			levelUp = false;
		}
	}
	
}
