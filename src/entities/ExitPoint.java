package entities;

import entities.person.Attendant;
import entities.person.Customer;
import entities.vehicle.Vehicle;

public class ExitPoint {

	private String id;
	
	private Attendant attendant;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	public void setAttendant(Attendant attendant) {
		this.attendant = attendant;
	}
	
	public boolean exitVehicle(Customer c) {
		Vehicle v = c.getVehicle();
		if(attendant.isTicketPaid(v.getParkingTicket()))
			return true;
		
		return attendant.processPayment(v.getParkingTicket(), c.makePayment(v.getParkingTicket().calculateFare()));
		
	}
	
}
