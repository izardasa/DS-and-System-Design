package com.designpattern.proxy1;

public class InternetDemo {
	public static void main(String[] args) 
	{
		Internet net = new ProxyInternet();
		try {
			net.connecTo("abc1.com");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}
}
