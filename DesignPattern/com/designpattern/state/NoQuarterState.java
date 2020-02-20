package com.designpattern.state;

public class NoQuarterState implements State{
	private GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("You have inserted a quarter.");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
		
	}

	@Override
	public void ejectQuarter() {
		System.out.println("Sorry, You haven't inserted the quarter");
		
	}

	@Override
	public void turnCrank() {
		System.out.println("Please insert a quarter first.");
		
	}

	@Override
	public void dispense() {
		System.out.println("You have to pay first.");
		
	}

}
