package systemdesign.parkinglot.models;

import systemdesign.parkinglot.enums.VehicleType;

public abstract class Vehicle {

	private String licenseNumber;
	private VehicleType vehicleType;
	private ParkingTicket parkingTicket;

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Vehicle(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public void assignTicket(ParkingTicket ticket) {
		this.parkingTicket = ticket;
	}
}
