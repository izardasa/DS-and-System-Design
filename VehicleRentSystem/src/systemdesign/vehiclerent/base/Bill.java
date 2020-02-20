package systemdesign.vehiclerent.base;

import java.util.List;

public class Bill {
private double totalAmount;
private List<BillItem> billItems;

public boolean addBillItems(BillItem billItem){return true;}
}
