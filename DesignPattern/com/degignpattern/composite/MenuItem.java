package com.degignpattern.composite;

public class MenuItem extends MenuComponent{
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

	public boolean isVegetarian() {
		return veg;
	}

	public double getPrice() {
		return price;
	}
	
	public void print()
	{
		System.out.print(" "+getName() );
		if(isVegetarian())
		{
			System.out.print("(V)");
		}
		System.out.print(", "+getPrice());
		System.out.println(" -- "+getDescription());
	}

}
