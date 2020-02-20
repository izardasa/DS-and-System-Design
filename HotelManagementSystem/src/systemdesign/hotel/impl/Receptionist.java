package systemdesign.hotel.impl;

import java.util.Date;
import java.util.List;

import systemdesign.hotel.base.RoomType;
import systemdesign.hotel.base.Search;

public class Receptionist extends Person implements Search{
public boolean makeBookigs(Booking booking){return true;}

@Override
public List<Room> search(Date startDate, RoomType type, int duration) {
	// TODO Auto-generated method stub
	return null;
}
}
