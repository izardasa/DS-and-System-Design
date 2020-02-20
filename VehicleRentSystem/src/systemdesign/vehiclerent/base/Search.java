package systemdesign.vehiclerent.base;

import java.util.List;

import systemdesign.vehiclerent.enums.VehicleType;

public interface Search {
public List<Vehicle> searchByModel(String model);
public List<Vehicle> searchByType(VehicleType type);
}
