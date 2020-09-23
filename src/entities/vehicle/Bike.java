package entities.vehicle;

import enums.VEHICLE_TYPE;

public class Bike extends Vehicle {

	@Override
	public void setVehicleType() {
		this.vehicleType = VEHICLE_TYPE.BIKE;
		
	}

}
