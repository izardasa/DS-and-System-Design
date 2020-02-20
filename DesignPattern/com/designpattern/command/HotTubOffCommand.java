package com.designpattern.command;

public class HotTubOffCommand implements Command {
	private HotTub hotTub;

	public HotTubOffCommand(HotTub hotTub) {
		super();
		this.hotTub = hotTub;
		 
	}

	@Override
	public void execute() {
		hotTub.off();

	}

	@Override
	public void undo() {
		hotTub.on();
		
	}

}
