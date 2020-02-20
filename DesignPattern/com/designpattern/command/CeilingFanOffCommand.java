package com.designpattern.command;

public class CeilingFanOffCommand implements Command {

	private CeilingFan ceilingFan;
	int previousSpeed;
	public CeilingFanOffCommand(CeilingFan ceilingFan) {
		super();
		this.ceilingFan = ceilingFan;
	}

	@Override
	public void execute() {
		previousSpeed = ceilingFan.getSpeed();
		ceilingFan.off();
		

	}

	@Override
	public void undo() {
		if (ceilingFan.LOW == previousSpeed)
			ceilingFan.low();
		else if (ceilingFan.HIGH == previousSpeed)
			ceilingFan.high();
		else if (ceilingFan.MED == previousSpeed)
			ceilingFan.medium();
		else
			ceilingFan.off();
		
	}

}
