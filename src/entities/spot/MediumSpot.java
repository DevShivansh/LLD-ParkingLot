package entities.spot;

import enums.SPOT_SIZE;

public class MediumSpot extends ParkingSpot {

	@Override
	public void setSpotSize() {
		this.spotSize = SPOT_SIZE.MEDIUM;
		
	}

}
