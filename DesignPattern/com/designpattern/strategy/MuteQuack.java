package com.designpattern.strategy;

public class MuteQuack implements QuackBehaviour {

	@Override
	public void quack() {
		System.out.println("<<Silence>>");
	}

}
