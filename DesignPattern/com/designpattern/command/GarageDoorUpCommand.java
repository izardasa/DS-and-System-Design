package com.designpattern.command;

public class GarageDoorUpCommand implements Command {
	private GarageDoor garageDoor;

	public GarageDoorUpCommand(GarageDoor garageDoor) {
		super();
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		garageDoor.up();

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
