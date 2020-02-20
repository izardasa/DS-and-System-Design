package com.designpattern.proxy;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GlobalMachineRemote{
	
	private static final long serialVersionUID = 2L;
	private State hasQuarterState;
	private State noQuarterState;
	private State soldState;
	private State soldOutState;

	int count;
	State state;
	private String location;

	public String getLocation() {
		return location;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public State getHasQuarterState() {
		return hasQuarterState;
	}

	public State getNoQuarterState() {
		return noQuarterState;
	}

	public State getSoldState() {
		return soldState;
	}

	public State getSoldOutState() {
		return soldOutState;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public GumballMachine(int count, String location) throws RemoteException {
		this.count = count;
		this.location = location;

		hasQuarterState = new HasQuarterState(this);
		noQuarterState = new NoQuarterState(this);
		soldOutState = new SoldOutState(this);
		soldState = new SoldState(this);

		if (count > 0)
			this.state = noQuarterState;
		else
			this.state = soldOutState;

	}

	public void insertQuarter() {
		state.insertQuarter();
	}

	public void turnCrank() {
		state.turnCrank();
		state.dispense();
	}

	public void ejectQuarter() {
		state.ejectQuarter();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Mighty Gumball, Inc.\n");
		str.append("Java enabled Standing Gumball Model #2019\n");
		str.append("Inventory " + count + " gumballs.\n");
		str.append("Machine is waiting for the quarter.\n");
		return str.toString();
	}
}
