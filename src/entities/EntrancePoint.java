package entities;

public class EntrancePoint {

	private String id;
	
	public ParkingTicket printTicket() {
		return new ParkingTicket();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
}
