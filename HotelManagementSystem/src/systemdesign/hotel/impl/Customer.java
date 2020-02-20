package systemdesign.hotel.impl;

import java.util.Date;
import java.util.List;

import systemdesign.hotel.base.RoomType;
import systemdesign.hotel.base.Search;

public class Customer extends Person implements Search{
private Date registrationDate;
private List<Room> checkedInRooms;
public boolean makeBooking(Booking booking){return true;}

public boolean cancelBooking(Booking booking){return true;}
public List<Booking> getBookings(){return null;}

@Override
public List<Room> search(Date startDate, RoomType type, int duration) {
	// TODO Auto-generated method stub
	return null;
}
}
