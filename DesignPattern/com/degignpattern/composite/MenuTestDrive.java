package com.degignpattern.composite;

import java.util.ArrayList;

public class MenuTestDrive {
	public static void main(String[] args) {
		MenuComponent pancakeHouseMenu = new Menu("PANCAKE HOUSE MENU", "Breakfast");
		MenuComponent dinerMenu = new Menu("DINNER MENU", "Lunch");
		MenuComponent cafeMenu = new Menu("CAFE MENU", "Dinner");
		MenuComponent desertMenu = new Menu("DESSERT MENU", "Dessert of course!");
		
		MenuComponent allMenus= new Menu("ALL MENU", "All Menus combined");
		
		allMenus.add(pancakeHouseMenu);
		allMenus.add(dinerMenu);
		allMenus.add(cafeMenu);
		

		
		cafeMenu.add(new MenuItem("Veggie Burger air fries", " Veggie burger on a whole wheat bun , lettuce, tomato and fries.",true, 3.99));
		cafeMenu.add(new MenuItem("Soup of the day", "A cup of the soup of the day with side salad",true, 3.69));
		cafeMenu.add(new MenuItem("Burrito", " A large burrito with whole pinto beans, salsa, guacamole.",true, 4.29));
		
		pancakeHouseMenu.add(new MenuItem("K&B's Pancake Breafast", "Pancake with scrambled egg and toast", true, 2.99));
		pancakeHouseMenu.add(new MenuItem("Regular Pancake Breafast", "Pancake with fried eggs", false, 2.99));
		pancakeHouseMenu.add(new MenuItem("Bleberry Pancakes", "Pancake with fresh blueberries", true, 3.49));
		pancakeHouseMenu.add(new MenuItem("Waffles", "Waffels, with your choice of blueberries and strawberries", true, 3.59));
		
		dinerMenu.add(new MenuItem("Vegetarian BLT", "(Fakin') Bacon lettuce and tomato on whole wheat", true, 2.99));
		dinerMenu.add(new MenuItem("BLT", " Bacon lettuce and tomato on whole wheat", false, 2.99));
		dinerMenu.add(new MenuItem("Soup of the day", "Soup of the day, with a side of potato salad", false, 3.29));
		dinerMenu.add(new MenuItem("Hotdog", "A hot dog with saurkraut, relish, onions, topped with cheese", false, 3.05));
		
		desertMenu.add(new MenuItem("Apple pie","Apple pie with flaky crust.",true,1.59));
		dinerMenu.add(desertMenu);
		
		Waitress waitress = new Waitress(allMenus);
		waitress.print();
	}
}
