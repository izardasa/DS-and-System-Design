package com.designpattern.factorypizza;

public class NYPizzaStore extends PizzaStore{

	Pizza pizza = null;
	PizzaIngredientFactory pizzaIngredientFactory = new NYPizzaIngredienFactory();
	@Override
	protected Pizza createPizza(String item) {
		if(item.equals("cheese"))
		{
			pizza =  new CheesePizza(pizzaIngredientFactory);
			pizza.setName("New York style cheeze pizza");
		}
		else if(item.equals("clam"))
		{
			pizza = new ClamPizza(pizzaIngredientFactory);
			pizza.setName("New York style clam pizza");
		}
		
		return pizza;
	}

}
