package com.designpattern.command;

public class StereoOnWithCDCommand implements Command {
	private Stereo stereo;

	public StereoOnWithCDCommand(Stereo stereo) {
		super();
		this.stereo = stereo;
	}

	@Override
	public void execute() {
		stereo.on();
		stereo.setCD();
		stereo.Volume();

	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
