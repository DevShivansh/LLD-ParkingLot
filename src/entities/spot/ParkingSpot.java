package entities.spot;

import entities.vehicle.Vehicle;
import enums.SPOT_SIZE;

public abstract class ParkingSpot {
	
	protected SPOT_SIZE spotSize;
	
	private String number;
	
	private boolean isFree;
	
	private Vehicle vehicle;
	
	
	public abstract void setSpotSize();


	public SPOT_SIZE getSpotSize() {
		return spotSize;
	}


	public void setSpotSize(SPOT_SIZE spotSize) {
		this.spotSize = spotSize;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public boolean isFree() {
		return isFree;
	}


	public void setFree(boolean isFree) {
		this.isFree = isFree;
	}


	public Vehicle getVehicle() {
		return vehicle;
	}


	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	// getters and setters 
	
}
