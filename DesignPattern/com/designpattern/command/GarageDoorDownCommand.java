package com.designpattern.command;

public class GarageDoorDownCommand implements Command {
	private GarageDoor garageDoor;

	public GarageDoorDownCommand(GarageDoor garageDoor) {
		super();
		this.garageDoor = garageDoor;
	}

	@Override
	public void execute() {
		garageDoor.down();

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
