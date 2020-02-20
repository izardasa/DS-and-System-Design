package systemdesign.vehiclerent.base;

import java.util.Date;

public class BarCode {
private String barCode;
private Date issuedAt;
private boolean isActive;

public boolean isActive()
{
	return isActive;
}
}
