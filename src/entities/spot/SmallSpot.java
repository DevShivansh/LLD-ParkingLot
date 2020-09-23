package entities.spot;

import enums.SPOT_SIZE;

public class SmallSpot extends ParkingSpot {

	@Override
	public void setSpotSize() {
		this.spotSize = SPOT_SIZE.SMALL;
		
	}

}
