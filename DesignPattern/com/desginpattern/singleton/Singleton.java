package com.desginpattern.singleton;

public class Singleton {
	
	private static Singleton myObj;
	
	private Singleton(){
		
	}
	
	public static Singleton getInstance()
	{
		if(null==myObj)
		{
			myObj = new Singleton();
		}
		return myObj;
	}
	
	public void printObject()
	{
		System.out.println("Hi, I am inside Singleton object.");
	}

}
