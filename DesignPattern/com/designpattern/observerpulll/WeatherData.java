package com.designpattern.observerpulll;

import java.util.Observable;

public class WeatherData extends Observable {
	private double humidity;
	private double temp;
	private double pressure;

	public WeatherData() {
	}

	public void measurementChange() {
		setChanged();
		notifyObservers();
	}

	public double getHumidity() {
		return humidity;
	}

	public double getTemp() {
		return temp;
	}

	public double getPressure() {
		return pressure;
	}

	public void setMeasurements(double temp, double humidity, double pressure) {
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		measurementChange();
	}

}
