package org.baltoaca.characters;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.baltoaca.objects.InventoryObject;


public class Inventory {
	private int maxSlots;
	private List<InventorySlot> inventory;
	
	
	public Inventory() {
		maxSlots = 10;
		inventory = new ArrayList<InventorySlot>();
	}

	public Inventory(int maxSlots){
		this();
		this.maxSlots = maxSlots;
	}
	
	public boolean hasObject(InventoryObject object){
		if(findSlotWithObjectIfExists(object) == null)
			return false;
		else
			return true;
	}
	
	public InventoryObject getObjectAtIndex(int index){
		InventorySlot slot = null;
		
		if(isIndexNotOutOfBounds(index)){
			slot = inventory.get(index);
			
			if(!slot.isEmpty()){
				return slot.getObject();
			}
		}
		
		return null;
	}

	private boolean isIndexNotOutOfBounds(int index) {
		try{
			inventory.get(index);
			return true;
		}catch (IndexOutOfBoundsException e) {
			return false;
		}
	}

	public void addObjectIfNotFull(InventoryObject object){
		if(!isFull()){
			incrementOrAddObject(object);
		}
	}

	public boolean isFull(){
		if(maxSlots == inventory.size())
			return true;
		else
			return false;
	}

	public void removeObjectIfExists(InventoryObject object){
		InventorySlot slot = findSlotWithObjectIfExists(object);
		slot.decrementAmount();
		removeEmptySlots();
	}

	private void removeEmptySlots() {
		Iterator<InventorySlot> iter = inventory.iterator();
		
		while(iter.hasNext()){
			InventorySlot slot = iter.next();
			if(slot.isEmpty())
				iter.remove();
		}
	}

	private void incrementOrAddObject(InventoryObject object) {
		InventorySlot slot = null;
		slot = findSlotWithObjectIfExists(object);
		
		if(slot != null){
			slot.incrementAmount();
		}else{
			inventory.add(buildSlot(object));
		}
	}

	private InventorySlot findSlotWithObjectIfExists(InventoryObject object){
		for (InventorySlot slot : inventory) {
			if(slot.hasObject(object))
				return slot;
		}
		
		return null;
	}

	private InventorySlot buildSlot(InventoryObject object) {
		return new InventorySlot(object);
	}

	@Override
	public String toString() {
		return "Inventory [maxSlots=" + maxSlots + ", inventory=" + inventory
				+ "]";
	}
	
	
		
}