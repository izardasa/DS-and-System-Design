package com.designpattern.factorypizza;

public class ChicagoPizzaStore extends PizzaStore{
Pizza pizza;
PizzaIngredientFactory ingredienFactory = new ChicagoPizzaIngredienFactory();
	@Override
	protected Pizza createPizza(String type) {
		if(type.equals("cheese"))
		{
			pizza = new CheesePizza(ingredienFactory);
			pizza.setName("Chicago style cheeze pizza");
		}
		else if(type.equals("clam"))
		{
			pizza = new ClamPizza(ingredienFactory);
			pizza.setName("Chicago style clam pizza");
		}
		
		return pizza;
	}

}
