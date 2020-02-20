package com.designpattern.abstractfactory;

public class AbstractFactoryDemo {

	public static void main(String[] args) {
		AbstractFactory factory = FactoryProducer.getFactory(true);
		Color color = factory.getColor("Red");
		color.paint();
		
		AbstractFactory factory2= FactoryProducer.getFactory(false);
		Shape shape = factory2.getShape("Circle");
		shape.draw();

	}

}
