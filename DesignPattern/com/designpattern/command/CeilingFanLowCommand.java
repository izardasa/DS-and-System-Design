package com.designpattern.command;

public class CeilingFanLowCommand implements Command {

	private CeilingFan ceilingFan;
	private int previousSpeed;

	public CeilingFanLowCommand(CeilingFan ceilingFan) {
		super();
		this.ceilingFan = ceilingFan;
	}

	@Override
	public void execute() {
		previousSpeed = ceilingFan.getSpeed();
		ceilingFan.low();

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
