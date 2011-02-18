package org.baltoaca.characters;

import org.baltoaca.objects.InventoryObject;

public class InventorySlot {
	private int amount;
	private InventoryObject object;
	
	
	public InventorySlot(InventoryObject object) {
		amount = 1;
		this.object = object;
	}


	public InventorySlot(int ammount, InventoryObject object) {
		this.amount = ammount;
		this.object = object;
	}
	
	public boolean hasObject(InventoryObject object){
		if(this.object.equals(object))
			return true;
		else
			return false;
	}
	
	public void incrementAmount(){
		amount++;
	}
	
	public void decrementAmount(){
		amount--;
	}
	
	public void setAmountToZero(){
		amount = 0;
	}
	
}
