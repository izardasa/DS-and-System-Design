package systemdesing.moviebooking.impl;

import java.util.List;

import systemdesing.moviebooking.enums.BookingStatus;

public class Booking {
private int id;
private Show show;
private Movie movieId;
private BookingStatus status;
private List<ShowSeat> seats;

private Payment payment;
public boolean makePayment(Payment payment){return true;}
public boolean cancel(){return true;}

public boolean assignSeats(){return true;}
}
