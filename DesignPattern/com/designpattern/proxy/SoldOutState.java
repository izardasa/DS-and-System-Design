package com.designpattern.proxy;

public class SoldOutState implements State {
	private GumballMachine gumballMachine;

	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}

	@Override
	public void insertQuarter() {
		System.out.println("Sorry, there are no gumballs");

	}

	@Override
	public void ejectQuarter() {
		System.out.println("You can't eject. You haven't inserted a quarter");

	}

	@Override
	public void turnCrank() {
		System.out.println("Sorry, this machine is sold out.");

	}

	@Override
	public void dispense() {
		System.out.println("Sorry, this machine is sold out.");

	}
@Override
public String toString() {
	// TODO Auto-generated method stub
	return "Sold out";
}
}
