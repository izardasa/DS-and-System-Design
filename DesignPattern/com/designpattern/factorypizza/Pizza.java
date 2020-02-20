package com.designpattern.factorypizza;

import java.util.ArrayList;

public abstract class Pizza {
	String name;
	Dough dough;
	Sauce sauce;
	Veggies[] veggies;
	Cheese cheese;
	Pepperoni pepperoni;
	Clams clam;
	
	abstract void perpare();

	ArrayList<String> toppings = new ArrayList<String>();

	void bake()
	{
		System.out.println("Bake for 25 minutes at 350");
	}
	
	void cut()
	{
		System.out.println("Cuttin pizza into diagonal slices.");
	}
	
	void box()
	{
		System.out.println("Place pizza in official pizza store box.");
	}
	
	public String getName()
	{
		return name;
	}
	
	void setName(String name)
	{
		this.name = name;
	}
}
