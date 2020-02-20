package systemdesign.parkinglot.models;

import java.util.HashMap;

public class ParkingFloor {
	private String name;
	private HashMap<String, HandicappedSpot> handicappedSpots;
	private HashMap<String, ElectricSpot> electricSpots;
	private HashMap<String, LargeSpot> largeSpots;
	private HashMap<String, CompactSpot> compactSpots;
	private DisplayBoard displayBoard;
	
	private int freeElectricSpots;
	private int freeLargeSpots;
	private int freeCompactSpots;
	private int maxElectricSpots;
	private int maxCompactSpots;
	private int maxLargeSpots;
	
	public ParkingFloor(int maxElectricSpots, int maxCompactSpots, int maxLargeSpots) {
		this.maxCompactSpots = maxLargeSpots;
		this.maxElectricSpots = maxElectricSpots;
		this.maxLargeSpots = maxLargeSpots;
	}

	public void addSpots(ParkingSpot parkingSpot) {
		switch (parkingSpot.getParkingSpotType()) {
		case Compact:
			compactSpots.put(parkingSpot.getNumber(), (CompactSpot) parkingSpot);
			break;

		case Electric:
			electricSpots.put(parkingSpot.getNumber(), (ElectricSpot) parkingSpot);
			break;

		case Handicapped:
			handicappedSpots.put(parkingSpot.getNumber(), (HandicappedSpot) parkingSpot);
			break;

		case Large:
			largeSpots.put(parkingSpot.getNumber(), (LargeSpot) parkingSpot);
			break;
		default:
			break;
		}
	}

	public boolean isFull()
	{
		return maxLargeSpots+maxCompactSpots+maxElectricSpots<=freeLargeSpots+freeElectricSpots+freeCompactSpots;
	}
	public void assignVehicleToSpot(Vehicle vehicle, ParkingSpot spot) {
		spot.assignVehicle(vehicle);
		switch (spot.getParkingSpotType()) {
		case Large:
			updateDisplayBoardForLargeSpot(spot);
			break;

		case Compact:
			updateDisplayBoardForCompactSpot(spot);
			break;

		case Handicapped:
			updateDisplayBoardForHandicappedSpot(spot);
			break;

		case Electric:
			updateDisplayBoardForElectrictSpot(spot);
			break;

		}

	}

	private void updateDisplayBoardForElectrictSpot(ParkingSpot spot) {
		if (displayBoard.getFreeElectricSpot().getNumber() == spot.getNumber()) {
			for (String key : electricSpots.keySet()) {
				if (electricSpots.get(key).isFree())
					displayBoard.setFreeElectricSpot(electricSpots.get(key));
			}
			this.displayBoard.showFreeSpots();
		}

	}

	private void updateDisplayBoardForHandicappedSpot(ParkingSpot spot) {
		if (displayBoard.getFreeHandicappedSpot().getNumber() == spot.getNumber()) {
			for (String key : handicappedSpots.keySet()) {
				if (handicappedSpots.get(key).isFree())
					displayBoard.setFreeHandicappedSpot(handicappedSpots.get(key));
			}
			this.displayBoard.showFreeSpots();
		}

	}

	private void updateDisplayBoardForCompactSpot(ParkingSpot spot) {
		if (displayBoard.getFreeCompactSpot().getNumber() == spot.getNumber()) {
			for (String key : compactSpots.keySet()) {
				if (compactSpots.get(key).isFree())
					displayBoard.setFreeCompactSpot(compactSpots.get(key));
			}
			this.displayBoard.showFreeSpots();
		}

	}

	private void updateDisplayBoardForLargeSpot(ParkingSpot spot) {
		if (this.displayBoard.getFreeLargeSpot().getNumber() == spot.getNumber()) {
			for (String key : largeSpots.keySet()) {
				if (largeSpots.get(key).isFree())
					this.displayBoard.setFreeLargeSpot(largeSpots.get(key));
			}
		}
		this.displayBoard.showFreeSpots();
	}

	public void removeVehicleFromSpot(ParkingSpot spot) {
		spot.removeVehicle();
	}
}
