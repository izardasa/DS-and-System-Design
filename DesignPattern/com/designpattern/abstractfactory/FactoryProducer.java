package com.designpattern.abstractfactory;

public class FactoryProducer {
	static AbstractFactory getFactory(boolean colorOrShape) {
		if (colorOrShape)
			return new ColorFactory();
		else
			return new ShapeFactory();
	}
}