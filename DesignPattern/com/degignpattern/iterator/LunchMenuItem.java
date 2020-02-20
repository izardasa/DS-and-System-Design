package com.degignpattern.iterator;

import java.util.ArrayList;
import java.util.Iterator;

public class LunchMenuItem implements Iterator<MenuItem>{

	ArrayList<MenuItem> items;
	int position = 0;
	public LunchMenuItem(ArrayList<MenuItem> items) {
		this.items = items;
	}
	@Override
	public boolean hasNext() {
		if(position>=items.size() || items.get(position)==null)
			return false;
		
		return true;
	}

	@Override
	public MenuItem next() {
		MenuItem item = items.get(position);
		position++;
		return item;
	}

}
