package entities.person;

import java.util.List;

import entities.Address;
import entities.EntrancePoint;
import entities.ExitPoint;
import entities.ParkingFloor;
import entities.ParkingLot;
import entities.spot.ParkingSpot;
import enums.ACCOUNT_STATUS;

public class Admin extends Person{
	
	private String userName;
	
	private String password;
	
	private ACCOUNT_STATUS status;

	
	
	public Admin(String name, Address address, String email, String phone, String password) {
		super(name, address, email, phone);
		this.userName = email;
		this.password = password;
		this.status = ACCOUNT_STATUS.ACTIVE;
	}


	public void addParkingFloor(ParkingFloor floor) {
		
		ParkingLot.getInstance().addFloor(floor);
	}
	
	
	public void addSpotsToFloor(String floor, List<ParkingSpot> spots) {
		
		ParkingLot.getInstance().addSpotsToFloor(floor, spots);
		
	}
	
	
	public void addEntranceToFloor(EntrancePoint entrancePoint) {
		
		ParkingLot.getInstance().addEntrance(entrancePoint);
	}
	
	
	public void addExitPointToFloor(ExitPoint exitPoint) {
		
		ParkingLot.getInstance().addExitPoints(exitPoint);
	}
	
	public void addAttendantToExitPoint(String exitId, Attendant attendant) {
		
		ParkingLot.getInstance().addAttendantToExitPoint(exitId, attendant);
	}
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ACCOUNT_STATUS getStatus() {
		return status;
	}

	public void setStatus(ACCOUNT_STATUS status) {
		this.status = status;
	}

	
}
