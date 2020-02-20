package systemdesign.parkinglot.models;

public class Admin extends Account {
	public boolean addParkingFloor(ParkingFloor parkingFloor) {	return true;};

	public boolean addParkingSpot(ParkingFloor parkingFloor, ParkingSpot parkingSpot) {return true;	};

	public boolean addParkingAttendant(ParkingFloor parkingFloor, ParkingAttendant parkingAttendant){return true;};

	public boolean addEntrancePanel(EntrancePanel entrancePanel){return true;};

	public boolean addExitPanel(ExitPanel exitPanel){return true;};
	
	public boolean addCustomerInfoPanel(CustomerInfoPanel customerInfoPanel, ParkingFloor parkingFloor){return true;};
	
	public boolean addDisplayBoard(DisplayBoard displayBoard, ParkingFloor parkingFloor){return true;};
}
