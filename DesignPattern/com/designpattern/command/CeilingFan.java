package com.designpattern.command;

public class CeilingFan {
	String name;
	public static final int OFF=0;
	public static final int LOW=1;
	public static final int MED=2;
	public static final int HIGH=3;

	private int speed;
	public CeilingFan(String name) {
		this.name = name;
		speed = OFF;
	}

	public void on() {
		System.out.println(name + " is on.");
	}

	public void off() {
		System.out.println(name + " is off.");
		speed= OFF;
	}
	
	public void high()
	{
		System.out.println(name+" is high");
		speed =HIGH;
	}
	public void medium()
	{
		System.out.println(name+" is medium");
		speed = MED;
	}
	
	public void low()
	{
		System.out.println(name+" is low");
		speed= LOW;
	}
	
	public int getSpeed()
	{
		return speed;
	}
}
