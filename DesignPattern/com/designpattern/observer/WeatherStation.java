package com.designpattern.observer;

public class WeatherStation {
	public static void main(String[] args) 
	{
		WeatherData weatherData = new WeatherData();
		CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
		weatherData.setMeasurements(10, 20, 30);
		weatherData.setMeasurements(11, 20, 31);
		weatherData.setMeasurements(18, 24, 33);
	}
}
