package com.designpattern.command;

public  class GarageDoor {
	String name;

	public GarageDoor(String name) {
		this.name = name;
	}
	
	public void up()
	{
		System.out.println(name +" door is open.");
	}
	public void down()
	{
		System.out.println(name+" door is closed.");
	}
	public void stop()
	{
		System.out.println(name +" door is stopped.");
	}
	public void lightOn()
	{
		System.out.println(name+" light is on.");
	}
	public void lightOff()
	{
		System.out.println(name+" light is off.");
	}
	
}
