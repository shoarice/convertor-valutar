package org.baltoaca.characters;

import org.baltoaca.stats.PlayerStats;

public class PlayerCharacter {
	private String name;
	private PlayerStats stats;
	private Inventory inventory;
	private EquippedSet equippedSet;
	
	public PlayerCharacter(String name, PlayerStats initialStats){
		this.name = name;
		this.stats = initialStats;
	}
}
