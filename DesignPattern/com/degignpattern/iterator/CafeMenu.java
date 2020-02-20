package com.degignpattern.iterator;

import java.util.HashMap;
import java.util.Iterator;

public class CafeMenu implements Menu{
	HashMap<String, MenuItem> menuItems;

	public CafeMenu() {
		menuItems = new HashMap<String, MenuItem>();
		addItem("Veggie Burger air fries", " Veggie burger on a whole wheat bun , lettuce, tomato and fries.",true, 3.99);
		addItem("Soup of the day", "A cup of the soup of the day with side salad",true, 3.69);
		addItem("Burrito", " A large burrito with whole pinto beans, salsa, guacamole.",true, 4.29);
		
	}
	
	public void addItem(String name, String desc, boolean veg, double price)
	{
		MenuItem item = new MenuItem(name, desc, veg, price);
		menuItems.put(name, item);
	}

	@Override
	public Iterator<MenuItem> createIterator() {
		return menuItems.values().iterator();
	}
	

}
