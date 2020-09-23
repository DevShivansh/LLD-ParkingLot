package entities.vehicle;

import enums.VEHICLE_TYPE;

public class Car extends Vehicle {

	@Override
	public void setVehicleType() {
		this.vehicleType = VEHICLE_TYPE.CAR;
		
	}

}
