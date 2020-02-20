package com.designpattern.template;

public class BeverageTestDrive {
	public static void main(String[] args) {
		System.out.println("Preparing tea.");
		Tea tea = new Tea();
		tea.prepareBeverage();

		System.out.println("preparing coffee");
		Coffee coffee = new Coffee();
		coffee.prepareBeverage();
	}
}
