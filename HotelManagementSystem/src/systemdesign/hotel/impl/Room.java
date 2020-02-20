package systemdesign.hotel.impl;

import java.util.Date;
import java.util.List;



import systemdesign.hotel.base.RoomType;
import systemdesign.hotel.base.Roomstatus;
import systemdesign.hotel.base.Search;

public class Room implements Search{
private int number;
private RoomType type;
private Roomstatus status;
private boolean noSmoking;
private double price;

private List<RookKey> keys;
private List<HouseKeeping> houseKeepings; 

public boolean checkin(){return true;}
public boolean checkout(){return true;}
public boolean isAvailable(){return true;}
@Override
public List<Room> search(Date startDate, RoomType type, int duration) {
	// TODO Auto-generated method stub
	return null;
}
}
