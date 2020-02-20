package systemdesign.hotel.base;

import java.util.Date;
import java.util.List;

import systemdesign.hotel.impl.Room;

public interface Search {
public List<Room> search(Date startDate, RoomType type, int duration);
}
