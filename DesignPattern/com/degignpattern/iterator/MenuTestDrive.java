package com.degignpattern.iterator;

import java.util.ArrayList;

public class MenuTestDrive {
	public static void main(String[] args) {
		PancakeHouseMenu breakfastMenu = new PancakeHouseMenu();
		DinnerMenu lunchMenu = new DinnerMenu();
		CafeMenu dinnerMenu = new CafeMenu();
		ArrayList<Menu> allMenu = new ArrayList<Menu>();
		allMenu.add(breakfastMenu);
		allMenu.add(lunchMenu);
		allMenu.add(dinnerMenu);
		
		Waitress waitress = new Waitress(allMenu);
		waitress.print();
	}
}
