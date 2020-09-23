package entities.person;

import entities.Address;
import entities.Payment;
import entities.vehicle.Vehicle;

public class Customer extends Person {

	
	private Vehicle vehicle;
	
	
	public Customer(String name, Address address, String email, String phone) {
		super(name, address, email, phone);
	
	}


	public Payment makePayment(double amount) {
		return new Payment(amount);
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	
	
	
}
