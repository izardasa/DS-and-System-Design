package com.designpattern.proxy;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface GlobalMachineRemote extends Remote
{
	public State getState() throws RemoteException;
	public int getCount() throws RemoteException;
	public String getLocation() throws RemoteException;
}
