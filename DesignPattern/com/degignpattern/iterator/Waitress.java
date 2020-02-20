package com.degignpattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class Waitress {
	ArrayList<Menu> menus;

	public Waitress(ArrayList<Menu> menus) {
		this.menus = menus;

	}

	public void print() {
		Iterator iterator = menus.iterator();
		
		while(iterator.hasNext())
		{
			System.out.println("Menu Item");
			print(((Menu)iterator.next()).createIterator());
		}

	}

	public void print(Iterator<MenuItem> iterator) {
		while (iterator.hasNext()) {
			MenuItem item = (MenuItem) iterator.next();
			System.out.print(item.getName());
			System.out.print(item.getDescription());
			System.out.print(item.getPrice());
			System.out.println("Veg :" + item.isVeg());

		}

	}

}
