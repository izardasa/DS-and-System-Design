package systemdesign.vehiclerent.base;

import java.util.Date;
import java.util.List;

import systemdesign.vehiclerent.enums.VehicleStatus;

public abstract class Vehicle {
private String vehicleNo;
private BarCode barCode;
private int capacity;
private String model;
private String make;
private Date mfg;
private VehicleStatus status;
private List<VehicleLog> logs;

public boolean reserveVehicle(){return true;}
public boolean returnVehicle(){return true;}

}
