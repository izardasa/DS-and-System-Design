package systemdesign.vehiclerent.base;

import java.util.HashMap;
import java.util.List;

import systemdesign.vehiclerent.enums.VehicleType;

public class VehicleInventory implements Search{

	private HashMap<String,List<Vehicle>> vehiclesByModel;
	private HashMap<VehicleType,List<Vehicle>> vehiclesByType;
	
	public VehicleInventory() {
		//Code for getting all vehicles
	}
	@Override
	public List<Vehicle> searchByModel(String model) {
		return vehiclesByModel.get(model);
	}

	@Override
	public List<Vehicle> searchByType(VehicleType type) {
		return vehiclesByType.get(type);
	}

}
