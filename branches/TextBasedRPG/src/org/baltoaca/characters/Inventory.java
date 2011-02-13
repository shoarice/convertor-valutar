package org.baltoaca.characters;

import java.util.HashMap;
import java.util.Map;

import org.baltoaca.objects.InvetoryObject;

public class Inventory {
	Map<InvetoryObject, Integer> objects;
	int maxSlots;
	
	public Inventory(){
		maxSlots = 10;
		objects = getMap();
	}
	
	public Inventory(int maxSlots){
		this();
		this.maxSlots = maxSlots;
	}
	
	//TODO create the methods that add and remove objects
	
	protected Map<InvetoryObject, Integer> getMap(){
		return new HashMap<InvetoryObject, Integer>();
	}
	
	protected Map<InvetoryObject, Integer> getMap(Map<InvetoryObject, Integer> initialInventory){
		return new HashMap<InvetoryObject, Integer>(initialInventory);
	}
}
