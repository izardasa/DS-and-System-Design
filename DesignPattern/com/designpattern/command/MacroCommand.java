package com.designpattern.command;

public class MacroCommand implements Command {
	private String name;
	private Command[] commands;

	public MacroCommand(String name) {
		super();
		this.name = name;
	}

	public MacroCommand(Command[] commands) {
		super();
		this.commands = commands;
	}

	@Override
	public void execute() {
		for (Command command : commands)
			command.execute();
	}

	@Override
	public void undo() {
		for (Command command : commands)
			command.undo();
	}

}
