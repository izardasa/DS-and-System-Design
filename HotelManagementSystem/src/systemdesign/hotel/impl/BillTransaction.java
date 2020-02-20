package systemdesign.hotel.impl;

import java.util.Date;

import systemdesign.hotel.base.PaymentStatus;

public abstract class BillTransaction {
private Date transactionDate;
private PaymentStatus status;
public void initiateTransaction(){};
}
