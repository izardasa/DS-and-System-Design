package com.designpattern.proxy1;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet{

	RealInternet internet = new RealInternet();
	static List<String> siteNames;
	static{
		siteNames = new ArrayList<String>();
		siteNames.add("abc.com");
		siteNames.add("xyz.com");
		siteNames.add("hello123.com");
		
	}
	@Override
	public void connecTo(String siteName) throws Exception {
		if(siteNames.contains(siteName))
		{
			throw new Exception("Invalid website url.");
		}
		internet.connecTo(siteName);
	}

}
