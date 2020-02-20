package com.designpattern.observer;

public class CurrentConditionDisplay implements Observer, DisplayElement {

	private double humidity;
	private double temp;
	private double pressure;
	private WeatherData weatherData;
	public CurrentConditionDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		this.weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("Weather Changed.");
		System.out.println("Humidity:" + this.humidity);
		System.out.println("Temperature:" + this.temp);
		System.out.println("Pressure:" + this.pressure);

	}

	@Override
	public void update(double temp, double humidity, double pressure) {
		this.temp = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

}
