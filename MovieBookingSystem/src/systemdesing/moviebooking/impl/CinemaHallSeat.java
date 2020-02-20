package systemdesing.moviebooking.impl;

import systemdesing.moviebooking.enums.SeatType;

public class CinemaHallSeat {
private int numberOfRows;
private int numberOfCols;
private SeatType type;
public int getNumberOfRows() {
	return numberOfRows;
}
public void setNumberOfRows(int numberOfRows) {
	this.numberOfRows = numberOfRows;
}
public int getNumberOfCols() {
	return numberOfCols;
}
public void setNumberOfCols(int numberOfCols) {
	this.numberOfCols = numberOfCols;
}
public SeatType getType() {
	return type;
}
public void setType(SeatType type) {
	this.type = type;
}
}
