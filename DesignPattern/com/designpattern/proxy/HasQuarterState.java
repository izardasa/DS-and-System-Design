package com.designpattern.proxy;

public class HasQuarterState implements State {
	private GumballMachine gumballMachine;

	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("You can't insert the quarter again.");

	}

	@Override
	public void ejectQuarter() {
		System.out.println("Your quarter is returned.");
		gumballMachine.setState(gumballMachine.getNoQuarterState());

	}

	@Override
	public void turnCrank() {
		System.out.println("You have turned crank.");
		gumballMachine.setState(gumballMachine.getSoldState());
		

	}

	@Override
	public void dispense() {
		System.out.println("No gumballs dispnesed.");

	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "HasQuanter";
	}

}
