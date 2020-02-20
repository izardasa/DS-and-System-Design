package com.designpattern.dynamicproxy;

public class PersonBeanImpl implements PersonBean{

	private String name;
	private int age;
	private String city;
	private int rating;
	private int count=0;
	@Override
	public String getName() {
		return name;
	}

	@Override
	public int getAge() {
		return age;
	}

	@Override
	public String getCity() {
		return city;
	}

	@Override
	public int getHotOrNot() {
		if(count==0) return 0;
		return rating/count;
	}

	@Override
	public void setName(String name) {
		this.name = name;
		
	}

	@Override
	public void setAge(int age) {
		this.age = age;
		
	}

	@Override
	public void setCity(String city) {
		this.city = city; 
		
		
	}

	@Override
	public void setHotOrNot(int rating) {
		this.rating += rating;
		count++;
		
	}

}
