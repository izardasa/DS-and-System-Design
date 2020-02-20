package com.designpattern.factorypizza;

public class ClamPizza extends Pizza{

	PizzaIngredientFactory ingredientFactory;
	
	public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory) {
		this.ingredientFactory = pizzaIngredientFactory;
	}
	@Override
	void perpare() {
		System.out.println("Preparing "+name);
		dough = ingredientFactory.createDough();
		sauce = ingredientFactory.createSauce();
		cheese = ingredientFactory.createCheese();
		clam = ingredientFactory.createClam();
		
	}

}
