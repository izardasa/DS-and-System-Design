package com.designpattern.proxy;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class GumballMachineTestDrive {
	
	public static void main(String[] args) {
		int count=0;
		if(args.length<2)
		{
			System.out.println("Gumball Machine <name> <inventory>");
			System.exit(1);
		}
		
		count = Integer.parseInt(args[1]);
		GumballMachine gumballMachine;
		try {
			gumballMachine = new GumballMachine(count, args[0]);
			Naming.rebind("//"+ args[0]+"/gumballmachine", gumballMachine);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		 
	}
}
