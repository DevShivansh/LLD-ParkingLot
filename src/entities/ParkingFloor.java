package entities;

import java.util.List;
import java.util.Map;

import entities.spot.CompactSpot;
import entities.spot.LargeSpot;
import entities.spot.MediumSpot;
import entities.spot.ParkingSpot;
import entities.spot.SmallSpot;
import entities.vehicle.Bike;
import entities.vehicle.Vehicle;
import enums.VEHICLE_TYPE;

public class ParkingFloor {

	private Map<String, CompactSpot> compactSpots;
	
	private Map<String, MediumSpot> mediumSpots;
	
	private Map<String, SmallSpot> smallSpots;
	
	private Map<String, LargeSpot> largeSpots;
	
	private DisplayPanel displayPanel;
	
	private String floorNumber;
	
	public boolean isFull() {
		return !displayPanel.isParkingAvailable();
	}
	
	
	public void updateDisplay() {
		
		if(displayPanel.isParkingAvailable())
			displayPanel.displayFreeSpots();
		else
			System.out.println(displayPanel.getMessage());
	}
	
	public boolean isSpotAvailableFor(VEHICLE_TYPE vehicleType) {
		
		return displayPanel.isParkingAvailableFor(vehicleType);
		
		
	}
	
	
	public void assignVehicleToSpot(Vehicle v) {

		ParkingSpot spot = displayPanel.getFreeSpotFor(v.getVehicleType());

		if (spot != null) {

			if (spot instanceof CompactSpot) {
				CompactSpot s = (CompactSpot) spot;
				compactSpots.put(s.getNumber(), s);
			} else if (spot instanceof SmallSpot) {
				SmallSpot s = (SmallSpot) spot;
				smallSpots.put(s.getNumber(), s);
			} else if (spot instanceof MediumSpot) {
				MediumSpot s = (MediumSpot) spot;
				mediumSpots.put(s.getNumber(), s);
			} else if (spot instanceof LargeSpot) {
				LargeSpot s = (LargeSpot) spot;
				largeSpots.put(s.getNumber(), s);
			}

		}

	}
	
	
	public void freeSpot(ParkingSpot spot) {

		if (spot != null) {

			if (spot instanceof CompactSpot) {
				CompactSpot s = (CompactSpot) spot;
				compactSpots.remove(s.getNumber(), s);
			} else if (spot instanceof SmallSpot) {
				SmallSpot s = (SmallSpot) spot;
				smallSpots.remove(s.getNumber(), s);
			} else if (spot instanceof MediumSpot) {
				MediumSpot s = (MediumSpot) spot;
				mediumSpots.remove(s.getNumber(), s);
			} else if (spot instanceof LargeSpot) {
				LargeSpot s = (LargeSpot) spot;
				largeSpots.remove(s.getNumber(), s);
			}

		}
	}

	public Map<String, CompactSpot> getCompactSpots() {
		return compactSpots;
	}


	public void setCompactSpots(Map<String, CompactSpot> compactSpots) {
		this.compactSpots = compactSpots;
	}


	public Map<String, MediumSpot> getMediumSpots() {
		return mediumSpots;
	}


	public void setMediumSpots(Map<String, MediumSpot> mediumSpots) {
		this.mediumSpots = mediumSpots;
	}


	public Map<String, SmallSpot> getSmallSpots() {
		return smallSpots;
	}


	public void setSmallSpots(Map<String, SmallSpot> smallSpots) {
		this.smallSpots = smallSpots;
	}


	public Map<String, LargeSpot> getLargeSpots() {
		return largeSpots;
	}


	public void setLargeSpots(Map<String, LargeSpot> largeSpots) {
		this.largeSpots = largeSpots;
	}


	public DisplayPanel getDisplayPanel() {
		return displayPanel;
	}


	public void setDisplayPanel(DisplayPanel displayPanel) {
		this.displayPanel = displayPanel;
	}


	public String getFloorNumber() {
		return floorNumber;
	}


	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}


	
	
}
