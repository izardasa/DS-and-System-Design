package com.designpattern.factory;

public class ShapeFactory {
	public Shape getShape(String shapeType) {
		Shape shape =null;
		if(null==shapeType)
			return shape;
		
		if("Circle".equalsIgnoreCase(shapeType))
			shape = new Circle();
		else if("Triangle".equalsIgnoreCase(shapeType))
			shape= new Triangle();
		else if("Rectangle".equalsIgnoreCase(shapeType))
			shape = new Rectangle();
		else
			shape = null;
		
		return shape;
	}
}
