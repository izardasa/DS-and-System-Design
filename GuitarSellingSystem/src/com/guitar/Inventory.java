package com.guitar;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Inventory {
	List<Instrument> inventory = new LinkedList<Instrument>();

	public void addInstrument(String serialNumber, double price, InstrumentSpec spec) {
		Instrument instrument = new Instrument(serialNumber, price, spec);
		this.inventory.add(instrument);
	}

	public Instrument get(String serialNumber) {
		for (Iterator i = inventory.iterator(); i.hasNext();) {
			Instrument instrument = (Instrument) i.next();
			if (instrument.getSerialNumber().equals(serialNumber))
				return instrument;

		}
		return null;
	}

	public List<Instrument> search(InstrumentSpec otherSpec) {
		List<Instrument> instrumentList = new LinkedList<Instrument>();
		for (Iterator instrumentIterator = this.inventory.iterator(); instrumentIterator.hasNext();) {
			Instrument instrument = (Instrument) instrumentIterator.next();
			if (instrument.getSpec().matches(otherSpec))
				instrumentList.add(instrument);
		}
		return instrumentList;
	}

}
