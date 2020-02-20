package systemdesign.hotel.impl;

import java.util.Date;

public abstract class Notification {
private String text;
private Date issuedAt;

public boolean send(String customerId){return true;}
}
