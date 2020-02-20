package com.degignpattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class PancakeHouseMenu implements Menu{
	ArrayList<MenuItem> menuItems;

	public PancakeHouseMenu() {
		menuItems = new ArrayList<MenuItem>();
		addItem("K&B's Pancake Breafast", "Pancake with scrambled egg and toast", true, 2.99);
		addItem("Regular Pancake Breafast", "Pancake with fried eggs", false, 2.99);
		addItem("Bleberry Pancakes", "Pancake with fresh blueberries", true, 3.49);
		addItem("Waffles", "Waffels, with your choice of blueberries and strawberries", true, 3.59);
	}

	public void addItem(String name, String desc, boolean veg, double price) {
		MenuItem menuItem = new MenuItem(name, desc, veg, price);
		menuItems.add(menuItem);
	}

	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}
	
	public Iterator createIterator()
	{
		return new LunchMenuItem(menuItems);
	}
}
