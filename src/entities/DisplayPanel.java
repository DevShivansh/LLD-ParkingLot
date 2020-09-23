package entities;

import java.beans.FeatureDescriptor;

import entities.spot.CompactSpot;
import entities.spot.LargeSpot;
import entities.spot.MediumSpot;
import entities.spot.ParkingSpot;
import entities.spot.SmallSpot;
import enums.VEHICLE_TYPE;

public class DisplayPanel {

	private String id;
	
	private String message;
	
	private CompactSpot freeCompactSpot;
	
	private SmallSpot freeSmallSpot;
	
	private MediumSpot freeMediumSpot;
	
	private LargeSpot freeLargeSpot;
	
	private boolean isParkingAvailable;
	
	public void displayFreeSpots() {
		
		if(freeCompactSpot.isFree())
			message += "Free Compact Spot Number : " + freeCompactSpot.getNumber();
		
		// DO SAME FOR OTHER FREE SPOTS
		
		System.out.println(message);
	}
	
	public boolean isParkingAvailableFor(VEHICLE_TYPE vehicleType) {
		
		ParkingSpot freeSpot = null;
		switch (vehicleType) {
		case BIKE:
			freeSpot = freeCompactSpot;
			break;
		case CAR:
			freeSpot = freeSmallSpot;
			break;
		case TRUCK:
			freeSpot = freeMediumSpot;
			break;
		case BUS:
			freeSpot = freeLargeSpot;
		default:
			break;
		}
		
		if(freeSpot != null)
			return true;
		
		return false;
	}
	
	
	public ParkingSpot getFreeSpotFor(VEHICLE_TYPE vehicleType) {
		
		ParkingSpot freeSpot = null;
		switch (vehicleType) {
		case BIKE:
			freeSpot = freeCompactSpot;
			break;
		case CAR:
			freeSpot = freeSmallSpot;
			break;
		case TRUCK:
			freeSpot = freeMediumSpot;
			break;
		case BUS:
			freeSpot = freeLargeSpot;
		default:
			break;
		}
		
		return freeSpot;
	}
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public CompactSpot getFreeCompactSpot() {
		return freeCompactSpot;
	}

	public void setFreeCompactSpot(CompactSpot freeCompactSpot) {
		this.freeCompactSpot = freeCompactSpot;
	}

	public SmallSpot getFreeSmallSpot() {
		return freeSmallSpot;
	}

	public void setFreeSmallSpot(SmallSpot freeSmallSpot) {
		this.freeSmallSpot = freeSmallSpot;
	}

	public MediumSpot getFreeMediumSpot() {
		return freeMediumSpot;
	}

	public void setFreeMediumSpot(MediumSpot freeMediumSpot) {
		this.freeMediumSpot = freeMediumSpot;
	}

	public LargeSpot getFreeLargeSpot() {
		return freeLargeSpot;
	}

	public void setFreeLargeSpot(LargeSpot freeLargeSpot) {
		this.freeLargeSpot = freeLargeSpot;
	}

	public boolean isParkingAvailable() {
		return isParkingAvailable;
	}

	public void setParkingAvailable(boolean isParkingAvailable) {
		this.isParkingAvailable = isParkingAvailable;
	}

	

	
}
