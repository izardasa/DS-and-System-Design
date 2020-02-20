package com.degignpattern.iterator;

import java.util.Iterator;

public class DinnerMenu implements Menu{
	static final int MAX_ITEMS = 6;
	int numberOfItems = 0;
	MenuItem[] menuItems;

	public DinnerMenu() {
		menuItems = new MenuItem[6];
		addItem("Vegetarian BLT", "(Fakin') Bacon lettuce and tomato on whole wheat", true, 2.99);
		addItem("BLT", " Bacon lettuce and tomato on whole wheat", false, 2.99);
		addItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29);
		addItem("Hotdog", "A hot dog with saurkraut, relish, onions, topped with cheese", false, 3.05);

	}

	public void addItem(String name, String desc, boolean veg, double price) {
		MenuItem menuItem = new MenuItem(name, desc, veg, price);
		if (numberOfItems >= MAX_ITEMS)
			System.err.println("Sorry, menu is full! Can't add items to menu.");
		else

			menuItems[numberOfItems++] = menuItem;
	}

	public MenuItem[] getMenuItems() {
		return menuItems;
	}
	
	public Iterator createIterator()
	{
		return new DinnerMenuIterator(menuItems);
	}
}
