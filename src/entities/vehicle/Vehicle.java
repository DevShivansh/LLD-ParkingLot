package entities.vehicle;

import entities.ParkingTicket;
import enums.VEHICLE_TYPE;

public abstract class Vehicle {

	private String numberPlate;
	
	protected VEHICLE_TYPE vehicleType;
	
	private ParkingTicket parkingTicket;
	
	public abstract void setVehicleType();

	public String getNumberPlate() {
		return numberPlate;
	}

	public void setNumberPlate(String numberPlate) {
		this.numberPlate = numberPlate;
	}

	public VEHICLE_TYPE getVehicleType() {
		return vehicleType;
	}


	public ParkingTicket getParkingTicket() {
		return parkingTicket;
	}

	public void setParkingTicket(ParkingTicket parkingTicket) {
		this.parkingTicket = parkingTicket;
	}
	
	
	
	
}
