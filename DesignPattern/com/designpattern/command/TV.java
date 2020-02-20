package com.designpattern.command;

public  class TV {
	String name;

	public TV(String name) {
		this.name = name;
	}
	
	public void on()
	{
		System.out.println(name+" is on.");
	}
	public void off()
	{
		System.out.println(name+" is off.");
	}
}
