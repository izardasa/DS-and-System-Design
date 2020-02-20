package com.designpattern.proxy1;

public class RealInternet implements Internet{

	@Override
	public void connecTo(String siteName) {
		System.out.println(" connecting to"+siteName);
		
	}

}
