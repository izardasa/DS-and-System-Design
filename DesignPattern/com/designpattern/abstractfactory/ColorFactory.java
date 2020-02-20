package com.designpattern.abstractfactory;

public class ColorFactory extends AbstractFactory{
public Color getColor(String colorType){
	Color color =null;
	if(null==colorType)
		return color;
	
	if("Red".equalsIgnoreCase(colorType))
	color = new Red();
	else if ("Green".equalsIgnoreCase(colorType))
		color = new Green();
	else if("Blue".equalsIgnoreCase(colorType))
		color = new Blue();
	else
		 color = null;
	
	return color;
	
}

@Override
public Shape getShape(String shapeType) {
	// TODO Auto-generated method stub
	return null;
}
}
