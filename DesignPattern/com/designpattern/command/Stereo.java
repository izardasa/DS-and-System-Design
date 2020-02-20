package com.designpattern.command;

public class Stereo {
	String name;

	public Stereo(String name) {
		super();
		this.name = name;
	}
	
	public void on()
	{
		System.out.println(name +" is on.");
	}
	
	public void off()
	{
		System.out.println(name+" is off.");
	}
	
	public void setCD()
	{
		System.out.println(name +" CD is set.");
	}
	public void setDVD()
	{
		System.out.println(name +" DVD is set.");
	}
	
	public void setRadio()
	{
		System.out.println(name+" Radio is set.");
	}
	public void Volume()
	{
		System.out.println(name+" volume is set.");
	}

}
