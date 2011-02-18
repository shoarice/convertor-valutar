package org.baltoaca.tests.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.baltoaca.characters.Inventory;
import org.baltoaca.objects.InventoryObject;
import org.junit.Test;

public class TestInventory {
	Inventory inventory;
	
	@Test
	public void printInventory(){
		inventory = new Inventory();
		addSomeObjectsToInventory(3);
		
		System.out.println(inventory);
	}
	
	@Test
	public void testAddingObjects(){
		inventory = new Inventory();
		addSomeObjectsToInventory(5);
		
		checkInventoryHead(5);
	}
	
	public void testAddingObjectsAtLimit(){
		inventory = new Inventory(30);
		addSomeObjectsToInventory(30);
		
		checkInventoryHead(30);
	}
	
	@Test
	public void testAddingObjectsOverTheLimit(){
		inventory = new Inventory(20);
		addSomeObjectsToInventory(30);
		
		checkInventoryHead(20);
		assertNull(inventory.getObjectAtIndex(21));
	}
	
	private void addSomeObjectsToInventory(int number){
		MyInventoryObject object;
		for(int i=0;i < number; i++){
			object = new MyInventoryObject(""+i);
			inventory.addObjectIfNotFull(object);
		}
	}
	
	private void checkInventoryHead(int number){
		MyInventoryObject expectedObject;
		for(int i=0;i < number; i++){
			expectedObject = new MyInventoryObject(""+i);
			assertEquals(expectedObject, inventory.getObjectAtIndex(i));
		}
	}

}


class MyInventoryObject extends InventoryObject{
	private String name;

	public MyInventoryObject(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MyInventoryObject other = (MyInventoryObject) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MyInventoryObject [name=" + name + "]";
	}
	
}
