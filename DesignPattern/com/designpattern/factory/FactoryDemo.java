package com.designpattern.factory;

public class FactoryDemo {

	public static void main(String[] args) {
		//Create a cicle
		ShapeFactory fact = new ShapeFactory();
		Shape shape = fact.getShape("Circle");
		shape.draw();
		
		//create a rectangle
		shape = fact.getShape("Rectangle");
		shape.draw();
		
		//create a triangle
		shape = fact.getShape("Triangle");
		shape.draw();
		

	}

}
