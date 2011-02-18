package org.baltoaca.characters;

import java.util.List;


public class Inventory {
	private int maxSlots;
	private List<InventorySlot> inventory;
	
	
	public Inventory() {
		maxSlots = 10;
	}


	public Inventory(int maxSlots){
		this.maxSlots = maxSlots;
	}
		
}