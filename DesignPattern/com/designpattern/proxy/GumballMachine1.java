package com.designpattern.proxy;

public class GumballMachine1 {
	public static int NO_QUARTER = 0;
	public static int HAS_QUARTER = 1;
	public static int SOLD = 2;
	public static int SOLD_OUT = 3;

	public int state;
	public int count;

	public GumballMachine1(int count) {
		this.count = count;
		this.state = NO_QUARTER;
	}

	public void insertQuarter() {
		if (state == NO_QUARTER) {
			state = HAS_QUARTER;
			System.out.println("You inserted a quarter.");
		} else if (state == HAS_QUARTER) {
			System.out.println("You can't insert another quarter.");
		} else if (state == SOLD) {
			System.out.println("Please wait. We're already giving you a gumball.");
		} else if (state == SOLD_OUT) {
			System.out.println("You can't insert a quarter. This machine is sold out.");
		}
	}

	public void ejectQuarter() {
		if (state == NO_QUARTER) {
			System.out.println("You haven't inserted a quarter.");
		} else if (state == HAS_QUARTER) {
			state = NO_QUARTER;
			System.out.println("Quarter returned");
		} else if (state == SOLD) {
			System.out.println("Sorry, You have already turned the crank.");
		} else if (state == SOLD_OUT) {
			System.out.println("You can't eject. You haven't inserted a quarter.");
		}
	}

	public void turnCrank() {
		if (state == NO_QUARTER) {
			System.out.println("You turned but there is no quarter.");
		} else if (state == HAS_QUARTER) {
			System.out.println("You turned the crank.");
			state = SOLD;
			dispense();
		} else if (state == SOLD) {
			System.out.println("Turing twice would not give you two gumballs.");
		} else if (state == SOLD_OUT) {
			System.out.println("You turned but there are no gumballs");
		}
	}

	private void dispense() {
		if (state == SOLD) {
			System.out.println("Your gumball is roling out.");
			count--;
			if (count == 0) {
				System.out.println("OOPS. Out of gumballs");
				state = SOLD_OUT;
			} else {
				state = NO_QUARTER;
			}
		} else if (state == SOLD_OUT) {
			System.out.println("No gumball dispensed");
		} else if (state == HAS_QUARTER) {
			System.out.println("No gumball dispensed.");
		} else if (state == NO_QUARTER) {
			System.out.println("You need to pay first.");
		}

	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("Mighty Gumball, Inc.\n");
		str.append("Java enabled Standing Gumball Model #2019\n");
		str.append("Inventory +" + count + " gumballs.\n");
		str.append("Machine is waiting for the quarter.\n");
		return str.toString();
	}

}
