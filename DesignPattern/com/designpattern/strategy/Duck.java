package com.designpattern.strategy;

public abstract class Duck {

	FlyBehavior flyBehavior;
	QuackBehaviour quackBehaviour;

	public Duck() {
		// TODO Auto-generated constructor stub
	}
	
	public void performQuack()
	{
		quackBehaviour.quack();
	}
	
	public void setFlyBehavior(FlyBehavior flyBehavior) {
		this.flyBehavior = flyBehavior;
	}

	public void setQuackBehaviour(QuackBehaviour quackBehaviour) {
		this.quackBehaviour = quackBehaviour;
	}

	public void performFly()
	{
		flyBehavior.fly();
	}
	
	public void swim()
	{
		System.out.println("All ducks float, even decoys.");
	}
}
