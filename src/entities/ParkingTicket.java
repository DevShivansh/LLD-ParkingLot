package entities;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

import enums.TICKET_STATUS;

public class ParkingTicket {

	private String ticketNumber;
	
	private String issuedTime;
	
	private String payedTime;
	
	private TICKET_STATUS ticketStatus;
	
	private final double baseFare = 20.00;
	
	private final double hourFare = 15.00;
	
	
	public Double calculateFare() {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		
		Timestamp issueTime = new Timestamp(Long.parseLong(issuedTime));
		
		int remainingHours = currentTime.getHours() - issueTime.getHours() - 1;
		
		if(remainingHours <= 0)
			return baseFare;
		else 
			return baseFare + (hourFare * remainingHours);
		
	}
	
	
	public ParkingTicket() {
		ticketNumber = "" + UUID.randomUUID();
		issuedTime = "" + System.currentTimeMillis();
		ticketStatus = TICKET_STATUS.ACTIVE;
	}

	public TICKET_STATUS getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(TICKET_STATUS ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public String getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getIssuedTime() {
		return issuedTime;
	}

	public void setIssuedTime(String issuedTime) {
		this.issuedTime = issuedTime;
	}

	public String getPayedTime() {
		return payedTime;
	}

	public void setPayedTime(String payedTime) {
		this.payedTime = payedTime;
	}
	
	
	
	
}
