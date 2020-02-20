package com.desginpattern.singleton;

public class SingletonDriver {

	public static void main(String[] args) {
		Singleton singletonObj = Singleton.getInstance();
		singletonObj.printObject();

	}

}
