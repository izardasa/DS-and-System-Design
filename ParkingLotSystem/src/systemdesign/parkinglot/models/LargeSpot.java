package systemdesign.parkinglot.models;

import systemdesign.parkinglot.enums.ParkingSpotType;

public class LargeSpot extends ParkingSpot{

	public LargeSpot() {
		super(ParkingSpotType.Large);
	}
	@Override
	public boolean isFree() {
		// TODO Auto-generated method stub
		return false;
	}

}
