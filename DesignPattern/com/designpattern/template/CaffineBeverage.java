package com.designpattern.template;

public abstract class CaffineBeverage {
	public final void prepareBeverage() {
		boilWater();
		brew();
		pourInCup();
		if (customerWantsCondiments()) {
			addCondiments();
		}
	}

	public boolean customerWantsCondiments() {

		return false;
	}

	public void boilWater() {
		System.out.println("Boiling water");
	}

	public abstract void brew();

	public void pourInCup() {
		System.out.println("Pouring in cup");
	}

	public abstract void addCondiments();

}
