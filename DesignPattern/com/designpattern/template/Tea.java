package com.designpattern.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tea extends CaffineBeverage{

	@Override
	public void brew() {
		System.out.println("put teabag in water.");
		
	}

	@Override
	public void addCondiments() {
		System.out.println("Adding some lemon drops.");
		
	}

	public boolean customerWantsCondiments() 
	{
		String answer = getUserInput();
		if(answer.startsWith("Y"))
			return true;
		else 
			return false;
		
	}

	private String getUserInput() {
		String answer = null;
		System.out.println("Would you like to add suger in coffee");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = br.readLine();
		} catch (IOException e) {
			return "no";
		}
		
		if(null != answer)
			return answer;
		return "no";
	}
}
