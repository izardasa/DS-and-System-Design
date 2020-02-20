package systemdesgin.vendingmachine.impl;

import java.util.HashMap;
import java.util.Map;

public class Inventory <T>{
	
	private Map<T,Integer> inventory = new HashMap<T,Integer>();
	
	public int getQuantity(T item)
	{
		Integer qty =	inventory.get(item);
		return qty==null?0:qty;
	}
	
	public void addItem(T item)
	{
		inventory.put(item, inventory.get(item)+1);
	}
	
	public boolean hasItem(T item)
	{
		return getQuantity(item)>0?true:false;
	}
	
	public void deduct(T item)
	{
		if(hasItem(item))
		{
			inventory.put(item, inventory.get(item)-1);
		}
	}
	
	public void clear()
	{
		inventory.clear();
	}
	
	public void put(T item, int qty)
	{
		inventory.put(item, qty);
	}

}
