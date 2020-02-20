package com.designpattern.abstractfactory;

public class ShapeFactory extends AbstractFactory{
public Shape getShape(String shapeType){
	Shape shape =null;
	if(null==shapeType)
		return shape;
	
	if("Circle".equalsIgnoreCase(shapeType))
	shape = new Circle();
	else if ("Rectangle".equalsIgnoreCase(shapeType))
		shape = new Rectangle();
	else if("Triangle".equalsIgnoreCase(shapeType))
		shape = new Triangle();
	else
		 shape = null;
	
	return shape;
	
}

@Override
public Color getColor(String color) {
	// TODO Auto-generated method stub
	return null;
}
}
