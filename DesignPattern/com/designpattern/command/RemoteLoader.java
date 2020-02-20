package com.designpattern.command;

public class RemoteLoader {
	public static void main(String[] args) {
		RemoteControl remoteControl = new RemoteControl();
		Light livingRoomLight = new Light("Living Room");
		Light kitchenLight = new Light("Kitchen");
		CeilingFan ceilingFan = new CeilingFan("Living Room Ceiling Fan");
		GarageDoor garageDoor = new GarageDoor("Garage Door");
		Stereo stereo = new Stereo("Living Room Stereo");
		TV tv = new TV("Living Room TV");
		HotTub hotTub = new HotTub("HotTub");
		/*LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
		CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
		CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);
		CeilingFanHighCommand ceilingFanHigh = new CeilingFanHighCommand(ceilingFan);
		CeilingFanLowCommand ceilingFanLow = new CeilingFanLowCommand(ceilingFan);
		CeilingFanMediumCommand ceilingFanMed = new CeilingFanMediumCommand(ceilingFan);
		GarageDoorUpCommand garageDoorup = new GarageDoorUpCommand(garageDoor);
		GarageDoorDownCommand garageDoorDown = new GarageDoorDownCommand(garageDoor);
		StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		*/
		
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		StereoOnWithCDCommand stereoOn = new StereoOnWithCDCommand(stereo);
		TVOnCommand tvOn = new TVOnCommand(tv);
		HotTubOnCommand hotTubOn = new HotTubOnCommand(hotTub);
		
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		StereoOffCommand stereoOff = new StereoOffCommand(stereo);
		TVOffCommand tvOff = new TVOffCommand(tv);
		HotTubOffCommand hotTubOff = new HotTubOffCommand(hotTub);
		
		
		Command[] partyOn = {livingRoomLightOn, stereoOn, tvOn, hotTubOn};
		Command[] partyOff = {livingRoomLightOff, stereoOff, tvOff, hotTubOff};
		MacroCommand macroCommandOn = new MacroCommand(partyOn);
		MacroCommand macroCommandOff = new MacroCommand(partyOff);
		
		remoteControl.setCommand(0, macroCommandOn, macroCommandOff);
		remoteControl.undoButtonWasPushed();
		//remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		//remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
		//remoteControl.setCommand(3, stereoOnWithCD, stereoOff);
		
		System.out.println(remoteControl);
		
		remoteControl.onButtonWsPushed(0);
		remoteControl.offButtonWasPushed(0);
		remoteControl.undoButtonWasPushed();
		
		remoteControl.onButtonWsPushed(1);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(1);
		remoteControl.undoButtonWasPushed();
		
		remoteControl.onButtonWsPushed(2);
		remoteControl.offButtonWasPushed(2);
		remoteControl.undoButtonWasPushed();
		
		/*remoteControl.onButtonWsPushed(1);
		remoteControl.offButtonWasPushed(1);
		remoteControl.onButtonWsPushed(2);
		remoteControl.offButtonWasPushed(2);
		remoteControl.onButtonWsPushed(3);
		remoteControl.offButtonWasPushed(3);*/
	}
}
