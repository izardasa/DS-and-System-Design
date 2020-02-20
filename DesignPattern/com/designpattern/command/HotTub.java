package com.designpattern.command;

public  class HotTub {
	String name;

	public HotTub(String name) {
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
