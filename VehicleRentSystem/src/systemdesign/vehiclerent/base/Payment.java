package systemdesign.vehiclerent.base;

import java.util.Date;

import systemdesign.vehiclerent.enums.PaymentStatus;

public abstract class Payment {
	private PaymentStatus status;
	private Date paymentDate;
	private String tranactionId;
	private double amount;

	public void initiateTransaction() {
	}
}
