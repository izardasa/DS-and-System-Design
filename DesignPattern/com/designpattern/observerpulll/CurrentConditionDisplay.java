package com.designpattern.observerpulll;

import java.util.Observable;
import java.util.Observer;
public class CurrentConditionDisplay implements Observer, DisplayElement {

	private double humidity;
	private double temp;
	private double pressure;
	private Observable observable;
	public CurrentConditionDisplay(Observable observable) {
		this.observable = observable;
		this.observable.addObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Weather Changed.");
		System.out.println("Humidity:" + this.humidity);
		System.out.println("Temperature:" + this.temp);
		System.out.println("Pressure:" + this.pressure);

	}

	@Override
	public void update(Observable o, Object arg) {
		if(o instanceof WeatherData)
		{
			WeatherData weatherData = (WeatherData)o;
			this.humidity = weatherData.getHumidity();
			this.temp = weatherData.getTemp();
			this.pressure = weatherData.getPressure();
			display();
		}
		
	}

}
