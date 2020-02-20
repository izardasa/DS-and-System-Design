package com.designpattern.command;

public class StereoOffCommand implements Command{
private Stereo stereo;

	public StereoOffCommand(Stereo stereo) {
	super();
	this.stereo = stereo;
}

	@Override
	public void execute() {
		stereo.off();
		
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		
	}

}
