package com.designpattern.factorypizza;

public class PizzaTestDrive {

	public static void main(String[] args) {
		PizzaStore pizzaStore = new NYPizzaStore();
		Pizza pizza  = pizzaStore.orderPizza("cheese");
		System.out.println("Ethan Ordered :"+pizza.name+" Dough: "+pizza.dough+" sauce: "+pizza.sauce);
		
		PizzaStore pizzaStore1 = new ChicagoPizzaStore();
		Pizza pizza1 = pizzaStore1.orderPizza("cheese");
		System.out.println("Joel ordered :"+pizza1.name+" Dough: "+pizza1.dough+" sauce: "+pizza1.sauce);
	}
}
