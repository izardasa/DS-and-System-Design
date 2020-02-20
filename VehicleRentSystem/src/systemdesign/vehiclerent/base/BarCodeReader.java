package systemdesign.vehiclerent.base;

import java.util.Date;

public class BarCodeReader {
private Date issuedAt;
private String id;
private boolean isActive;

public boolean isActive()
{
	return isActive;
}

public void readBarCode(BarCode barCode){}
}
