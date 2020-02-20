package systemdesign.hotel.impl;

import java.util.Date;
import java.util.List;

import systemdesign.hotel.base.Bookingstatus;

public class Booking {
private Customer customer;
private Bookingstatus status;
private Date bookingDate;
private Date checkin;
private Date checkout;
private int duration;
private List<Room> rooms;
private int numberOfMembers;
private int bookingID;
private Invoice invoice;
private List<Notification> notifications;

public Booking getBookingDetails(String bookingId){return null;}
}
