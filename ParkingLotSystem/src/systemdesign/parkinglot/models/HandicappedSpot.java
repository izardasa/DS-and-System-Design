package systemdesign.parkinglot.models;

import systemdesign.parkinglot.enums.ParkingSpotType;

public class HandicappedSpot extends ParkingSpot{

	public HandicappedSpot() {
		super(ParkingSpotType.Handicapped);
	}

	@Override
	public boolean isFree() {
		// TODO Auto-generated method stub
		return false;
	}

}
