package org.baltoaca.stats;

import java.util.Arrays;

public class ExperienceToLevelMapper {

	private int[] levelToExperience;
	
	public ExperienceToLevelMapper(int[] levelToExperience){
		this.levelToExperience = Arrays.copyOf(levelToExperience, levelToExperience.length);
	}
	
	public int getLevelFromExperience(int experience) {
		int length = levelToExperience.length;
		
		for(int i=0;i < length;i++){
			if(levelToExperience[i] > experience)
				return i-1;
		}
		
		return 0;
	}

}
