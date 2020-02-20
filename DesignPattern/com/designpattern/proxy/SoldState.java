package com.designpattern.proxy;

public class SoldState implements State{
	
	private GumballMachine gumballMachine;
	public SoldState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("Plwase wait. You have already wait.");
		
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Sorry, you have turned the crank.");
		
	}

	@Override
	public void turnCrank() {
		System.out.println("Turing crank twice will not give you two gumballs");
		
	}

	@Override
	public void dispense() {
		int count = gumballMachine.getCount(); 
		if(count>0)
		{
			System.out.println("Your gumball is rolling out");
			gumballMachine.setCount(count-1);
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		}
		else
		{
			System.out.println("This machine is sold out.");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
		
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Sold";
	}

}
