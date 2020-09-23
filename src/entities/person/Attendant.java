package entities.person;

import entities.Address;
import entities.ParkingTicket;
import entities.Payment;
import enums.TICKET_STATUS;

public class Attendant extends Person {

	public Attendant(String name, Address address, String email, String phone) {
		super(name, address, email, phone);
	}


	public boolean isTicketPaid(ParkingTicket ticket) {
		
		if(ticket.getTicketStatus() == TICKET_STATUS.PAID)
			return true;
		return false;
	}
	
	
	public boolean processPayment(ParkingTicket ticket, Payment payment) {
		
		if(payment.isPaid()) {
			
			ticket.setTicketStatus(TICKET_STATUS.PAID);
			ticket.setPayedTime("" + System.currentTimeMillis());
			return true;
		}
		
		return false;
		
	}
}
