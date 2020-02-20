package com.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Subject {
	private List<Observer> observers;
	private double humidity;
	private double temp;
	private double pressure;

	public WeatherData() {
		observers = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer o) {
		if (null != observers) {
			observers.add(o);
		}
	}

	@Override
	public void removeObserver(Observer o) {
		int indexOfObserver = observers.indexOf(o);
		if (indexOfObserver >= 0) {
			observers.remove(indexOfObserver);
		}

	}

	@Override
	public void notifyObservers() {

		for (Observer o : observers) {
			o.update(this.temp, this.humidity, this.pressure);
		}

	}

	public void measurementChange() {
		notifyObservers();
	}

	public void setMeasurements(double temp, double humidity, double pressure) {
		this.temp = temp;
		this.pressure = pressure;
		this.humidity = humidity;
		measurementChange();
	}

}
