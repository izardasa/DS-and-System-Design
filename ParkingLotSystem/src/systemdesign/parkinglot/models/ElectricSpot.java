package systemdesign.parkinglot.models;

import systemdesign.parkinglot.enums.ParkingSpotType;

public class ElectricSpot extends ParkingSpot{

	public ElectricSpot() {
		super(ParkingSpotType.Electric);
	}

	@Override
	public boolean isFree() {
		// TODO Auto-generated method stub
		return false;
	}

}
