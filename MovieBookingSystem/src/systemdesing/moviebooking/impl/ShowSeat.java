package systemdesing.moviebooking.impl;

public class ShowSeat extends CinemaHallSeat{
private String SeatId;
private double amount;
private boolean reserved;
public String getSeatId() {
	return SeatId;
}
public void setSeatId(String seatId) {
	SeatId = seatId;
}
public double getAmount() {
	return amount;
}
public void setAmount(double amount) {
	this.amount = amount;
}
public boolean isReserved() {
	return reserved;
}
public void setReserved(boolean reserved) {
	this.reserved = reserved;
}
}
