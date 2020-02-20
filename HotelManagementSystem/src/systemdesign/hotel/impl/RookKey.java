package systemdesign.hotel.impl;

import java.util.Date;

public class RookKey {
private int keyNumber;
private String barCode;
private boolean isMaster;
private Date issuedAt;

public boolean isActive(){return true;}
public boolean assignRoom(Room room){return true;}
}
