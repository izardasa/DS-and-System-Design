package com.designpattern.command;

public class HotTubOnCommand implements Command {
	private HotTub hotTub;

	public HotTubOnCommand(HotTub hotTub) {
		super();
		this.hotTub = hotTub;
		 
	}

	@Override
	public void execute() {
		hotTub.on();

	}

	@Override
	public void undo() {
		hotTub.off();
		
	}

}
