package entities;

import enums.PAYMENT_TYPE;
import enums.TICKET_STATUS;

public class Payment {

	private String creationDate;
	
	private double amount;
	
	private PAYMENT_TYPE paymentType;
	
	private TICKET_STATUS status;
	
	public Payment(double amount) {
		creationDate = "" + System.currentTimeMillis();
		this.amount = amount;
		status = TICKET_STATUS.PAID;
	}
	
	public boolean isPaid() {
		
		if(status == TICKET_STATUS.PAID)
			return true;
		
		return false;
	}
}
