package systemdesign.parkinglot.models;

import systemdesign.parkinglot.enums.ParkingSpotType;

public abstract class ParkingSpot {
	private String number;
	private boolean free;
	private ParkingSpotType parkingSpotType;
	private Vehicle vehicle;
	public Vehicle getVehicle() {
		return vehicle;
	}
	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	public void assignVehicle(Vehicle vehicle)
	{
		this.vehicle = vehicle;
		this.free = false;
	}
	
	public void removeVehicle()
	{
		this.vehicle = null;
		this.free = true;
	}
	public ParkingSpot(ParkingSpotType parkingSpotType)
	{
		this.parkingSpotType = parkingSpotType;
	}

	public ParkingSpotType getParkingSpotType() {
		return parkingSpotType;
	}

	public void setParkingSpotType(ParkingSpotType parkingSpotType) {
		this.parkingSpotType = parkingSpotType;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean getFree() {
		return free;
	}

	public void setFree(boolean free) {
		this.free = free;
	}

	public boolean isFree()
	{
		return free;
	};
	
	
}
