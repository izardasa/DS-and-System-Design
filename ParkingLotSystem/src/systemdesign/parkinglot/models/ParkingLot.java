package systemdesign.parkinglot.models;

import java.util.HashMap;

import systemdesign.parkinglot.enums.VehicleType;

public class ParkingLot {
	private int compactSpotCount;
	private int handicappedSpotCount;
	private int largeSpotCount;
	private int electricSpotCount;
	private int motorBikeSpotCount;

	private int maxCompactSpotCount;
	private int maxHandicappedSpotCount;
	private int maxLargeSpotCount;
	private int maxElectricSpotCount;
	private int maxMotorBikeSpotCount;
	private HashMap<String, ParkingTicket> activeTickets;
	private HashMap<String, ParkingFloor> floors;

	private static ParkingLot instance = null;

	private ParkingLot() {

	}

	public static ParkingLot getInstance() {
		if (instance == null) {
			instance = new ParkingLot();
		}
		return instance;
	}

	public synchronized ParkingTicket getNewParkingTicket(Vehicle vehicle) throws Exception {
		if (this.isFull(vehicle.getVehicleType()))
			throw new Exception("Parking is full.");

		ParkingTicket ticket = new ParkingTicket();
		vehicle.assignTicket(ticket);
		this.incrementSpotCount(vehicle.getVehicleType());
		this.activeTickets.put(ticket.getNumber(), ticket);
		return ticket;

	}

	private void incrementSpotCount(VehicleType vehicleType) {
		if (vehicleType == VehicleType.Van || vehicleType == VehicleType.Truck)
			largeSpotCount++;
		else if (vehicleType == VehicleType.Motorbike)
			motorBikeSpotCount++;
		else if (vehicleType == VehicleType.Car) {
			if (compactSpotCount < maxCompactSpotCount)
				compactSpotCount++;
			else
				largeSpotCount++;
		} else {
			if (electricSpotCount < maxElectricSpotCount)
				electricSpotCount++;
			else if (compactSpotCount < maxCompactSpotCount)
				compactSpotCount++;
			else if (largeSpotCount < maxLargeSpotCount)
				largeSpotCount++;
		}

	}

	public boolean isFull(VehicleType type) {
		if (type == VehicleType.Motorbike)
			return motorBikeSpotCount <= maxMotorBikeSpotCount;

		if (type == VehicleType.Car)
			return (compactSpotCount + largeSpotCount) <= (maxCompactSpotCount + maxLargeSpotCount);

		if (type == VehicleType.Truck || type == VehicleType.Van)
			return compactSpotCount <= maxCompactSpotCount;

		if (type == VehicleType.Electric)
			return (compactSpotCount + largeSpotCount + electricSpotCount) <= (compactSpotCount + largeSpotCount
					+ electricSpotCount);

		return true;
	}

	public boolean isFull() {
		for (String key : floors.keySet()) {
			if (!floors.get(key).isFull())
				return false;
		}

		return true;
	}

}
