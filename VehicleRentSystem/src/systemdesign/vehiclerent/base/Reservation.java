package systemdesign.vehiclerent.base;

import java.util.Date;
import java.util.List;

import systemdesign.vehiclerent.enums.ReservationStatus;

public class Reservation {
private String reservationId;
private Date reservationDate;
private Date pickupDate;
private Date returnDate;
private Date dueDate;
private int noOfDays;
private Vehicle vehicle;
private ReservationStatus status;
private Bill bill;
private List<Service> services;
private List<Insurance> insurances;
private List<Equipment> equipments;
private List<Notification> notifications;
public Reservation fetchDetails(String reservationId){return null;}
}
