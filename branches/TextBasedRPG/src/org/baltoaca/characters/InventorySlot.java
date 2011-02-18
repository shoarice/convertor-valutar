package org.baltoaca.characters;

import org.baltoaca.objects.InventoryObject;

public class InventorySlot {
	private int amount;
	private InventoryObject object;
		
	public InventorySlot(InventoryObject object) {
		amount = 1;
		this.object = object;
	}

	public InventorySlot(InventoryObject object, int ammount) {
		this.amount = ammount;
		this.object = object;
	}
	
	public boolean hasObject(InventoryObject object){
		if(this.object.equals(object))
			return true;
		else
			return false;
	}
	
	public void incrementAmountBy(int delta){
		amount+=delta;
	}
	
	public void decrementAmount(int delta){
		amount-=delta;
		if(amount < 0)
			amount = 0;
	}
	
	public void setAmount(int amount){
		this.amount = amount;
	}
	
	public boolean isEmpty(){
		if(amount == 0)
			return true;
		return false;
	}
	
	public void setAmountToZero(){
		amount = 0;
	}


	public InventoryObject getObject() {
		return object;
	}

	public int getAmount() {
		return amount;
	}

	@Override
	public String toString() {
		return "InventorySlot [amount=" + amount + ", object=" + object + "]";
	}
	
	
	
}
