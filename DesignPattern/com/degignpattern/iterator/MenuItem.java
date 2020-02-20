package com.degignpattern.iterator;

public class MenuItem {
	private String name;
	private String description;
	private boolean veg;
	private double price;

	public MenuItem(String name, String description, boolean veg, double price) {
		super();
		this.name = name;
		this.description = description;
		this.veg = veg;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public boolean isVeg() {
		return veg;
	}

	public double getPrice() {
		return price;
	}

}
