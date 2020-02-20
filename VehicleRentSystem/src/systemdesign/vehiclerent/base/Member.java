package systemdesign.vehiclerent.base;

import java.util.Date;
import java.util.List;

public class Member extends Account{
private String license;
private Date licenseExpiryDate;

public List<Reservation> getReservations(String userId){return null;}
}
