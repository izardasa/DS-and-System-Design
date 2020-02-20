package com.designpattern.decorator;

public class SteamedMilk extends CondimentDecorator{

	private Beverage beverage;
	
	public SteamedMilk(Beverage beverage) {
		this.beverage = beverage;
	}
	@Override
	public String getDescription() {
		return beverage.getDescription()+", Streamed Milk";
	}

	@Override
	public double cost() {
		return beverage.cost()+.10;
	}

}
