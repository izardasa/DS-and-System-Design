package systemdesign.parkinglot.models;

import systemdesign.parkinglot.enums.ParkingSpotType;

public class CompactSpot extends ParkingSpot {
	public CompactSpot() {
		super(ParkingSpotType.Compact);
	}

	@Override
	public boolean isFree() {
		// TODO Auto-generated method stub
		return false;
	}
}
