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
		if(findSlotWithObject(object) == null)
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
	public int getAmount(InventoryObject object){
		InventorySlot slot = findSlotWithObject(object);
		
		if(slot != null){
			return slot.getAmount();
		}else{
			return (Integer) null;
		}
	}
	
	public int getAmount(int index){
		InventorySlot slot = null;
		
		if(isIndexNotOutOfBounds(index)){
			slot = inventory.get(index);
			
			if(!slot.isEmpty()){
				return slot.getAmount();
			}
		}
		
		return (Integer) null;
		
	}

	public void decreaseAmountFromIndex(int index, int delta){
		InventorySlot slot = null;
		
		if(isIndexNotOutOfBounds(index)){
			slot = inventory.get(index);
			
			if(!slot.isEmpty()){
				slot.decrementAmount(delta);
				removeEmptySlots();
			}
		}	
	}

	public void addObject(InventoryObject object){
		incrementOrAddObjectIfNotFull(object);
	}
	
	public void addObject(InventoryObject object, int amount){
		incrementOrAddObjectIfNotFull(object, amount);
	}

	private void incrementOrAddObjectIfNotFull(InventoryObject object) {
		incrementOrAddObjectIfNotFull(object, 1);		
	}

	private void incrementOrAddObjectIfNotFull(InventoryObject object, int amount) {
		InventorySlot slot = null;
		slot = findSlotWithObject(object);
		
		if(slot != null){
			slot.incrementAmountBy(1);
		}else{
			if(!isFull()){
				inventory.add(buildSlot(object, amount));
			}
		}
	}

	public boolean isFull(){
		if(maxSlots == inventory.size())
			return true;
		else
			return false;
	}
	
	public boolean isEmpty() {
		return inventory.isEmpty();
	}
	
	public InventoryObject useObject(InventoryObject object, int amount){
		InventorySlot slot = findSlotWithObject(object);
		if(amount <= slot.getAmount()){
			slot.decrementAmount(amount);
			try{
				return slot.getObject();
			}finally{
				removeEmptySlots();
			}
		}
		else
			return null;
	}
	
	public InventoryObject useObject(int index, int amount){
		if(isIndexNotOutOfBounds(index)){
			InventorySlot slot = inventory.get(index);
			
			if(amount <= slot.getAmount()){
				slot.decrementAmount(amount);
				try{
					return slot.getObject();
				}finally{
					removeEmptySlots();
				}
			}
		}
		return null;
	}

	public void removeObject(InventoryObject object){
		InventorySlot slot = findSlotWithObject(object);
		slot.setAmountToZero();
		removeEmptySlots();
	}
	
	public void removeObject(int index){
		if(isIndexNotOutOfBounds(index)){
			InventorySlot slot = inventory.get(index);
			slot.setAmountToZero();
			removeEmptySlots();
		}
	}

	private void removeEmptySlots() {
		Iterator<InventorySlot> iter = inventory.iterator();
		
		while(iter.hasNext()){
			InventorySlot slot = iter.next();
			if(slot.isEmpty())
				iter.remove();
		}
	}
	
	
	private InventorySlot findSlotWithObject(InventoryObject object){
		for (InventorySlot slot : inventory) {
			if(slot.hasObject(object))
				return slot;
		}
		
		return null;
	}

	private InventorySlot buildSlot(InventoryObject object, int amount) {
		return new InventorySlot(object, amount);
	}

	@Override
	public String toString() {
		return "Inventory [maxSlots=" + maxSlots + ", inventory=" + inventory
				+ "]";
	}
	
	
		
}