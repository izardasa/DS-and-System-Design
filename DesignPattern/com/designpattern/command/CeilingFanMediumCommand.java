package com.designpattern.command;

public class CeilingFanMediumCommand implements Command {

	private CeilingFan ceilingFan;
	private int previousSpeed;

	public CeilingFanMediumCommand(CeilingFan ceilingFan) {
		super();
		this.ceilingFan = ceilingFan;
	}

	@Override
	public void execute() {
		previousSpeed = ceilingFan.getSpeed();
		ceilingFan.medium();

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
