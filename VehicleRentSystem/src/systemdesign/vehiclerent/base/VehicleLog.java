package systemdesign.vehiclerent.base;

import java.util.Date;
import java.util.List;

import systemdesign.vehiclerent.enums.VehicleLogType;

public class VehicleLog {
private VehicleLogType type;
private String description;
private Date logDate;

public List<VehicleLog> searchByLogType(VehicleLogType type){return null;}
public List<VehicleLog> searchByVehicle(Vehicle vehicle){return null;}
}
