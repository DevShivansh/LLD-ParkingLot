package entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import entities.person.Attendant;
import entities.person.Customer;
import entities.spot.CompactSpot;
import entities.spot.LargeSpot;
import entities.spot.MediumSpot;
import entities.spot.ParkingSpot;
import entities.spot.SmallSpot;
import entities.vehicle.Vehicle;
import enums.VEHICLE_TYPE;

public class ParkingLot {

	private String id;

	private Address address;

	private Map<String, ParkingFloor> floors;

	private Map<String, EntrancePoint> entrances;

	private Map<String, ExitPoint> exitPoints;

	private Map<String, ParkingTicket> parkingTickets;

	private static ParkingLot parkingLot;

	private ParkingLot() {
		this.id = "" + UUID.randomUUID();
		this.address = new Address();
	}

	public static ParkingLot getInstance() {

		if (parkingLot == null) {

			synchronized (parkingLot) {

				if (parkingLot == null)
					parkingLot = new ParkingLot();
			}
		}

		return parkingLot;
	}

	public void parkVehicle(String entranceId, Customer c) {
		parkVehicle(entranceId, c.getVehicle());
	}

	public void parkVehicle(String entranceId, Vehicle v) {

		EntrancePoint entrancePoint = entrances.get(entranceId);

		if (entrancePoint != null) {

			if (isParkingAvailable(v.getVehicleType())) {
				ParkingTicket ticket = entrancePoint.printTicket();
				v.setParkingTicket(ticket);
				registerParking(ticket);
				assignVehicleParkingSpot(v);
			}

		}
	}

	private void registerParking(ParkingTicket ticket) {

		if (parkingTickets == null)
			parkingTickets = new HashMap<String, ParkingTicket>();

		parkingTickets.putIfAbsent(ticket.getTicketNumber(), ticket);

	}

	private void assignVehicleParkingSpot(Vehicle v) {

		for (String floorNum : floors.keySet()) {

			ParkingFloor floor = floors.get(floorNum);

			if (!floor.isSpotAvailableFor(v.getVehicleType()))
				continue;

			floor.assignVehicleToSpot(v);

		}

	}

	private boolean isParkingAvailable(VEHICLE_TYPE vehicleType) {

		for (String floorNum : floors.keySet()) {

			ParkingFloor floor = floors.get(floorNum);

			if (floor.isSpotAvailableFor(vehicleType))
				return true;

		}
		return false;
	}

	public boolean exitVehicle(String exitPointId, Customer c) {

		ExitPoint exitPoint = exitPoints.get(exitPointId);

		if (exitPoint != null) {

			return exitPoint.exitVehicle(c);

		}
		return false;

	}

	public void addFloor(ParkingFloor floor) {

		if (floors == null)
			floors = new HashMap<String, ParkingFloor>();

		floors.putIfAbsent(floor.getFloorNumber(), floor);

	}

	public void addSpotsToFloor(String floorNum, List<ParkingSpot> spotList) {

		ParkingFloor floor = floors.get(floorNum);

		if (floor != null && !spotList.isEmpty()) {

			ParkingSpot spotType = spotList.get(0);

			if (spotType instanceof CompactSpot) {
				Map<String, CompactSpot> compactSpots = spotList.stream().map(spot -> (CompactSpot) spot)
						.collect(Collectors.toMap(CompactSpot::getNumber, i -> i));
				floor.setCompactSpots(compactSpots);
			} else if (spotType instanceof SmallSpot) {
				Map<String, SmallSpot> spots = spotList.stream().map(spot -> (SmallSpot) spot)
						.collect(Collectors.toMap(SmallSpot::getNumber, i -> i));
				floor.setSmallSpots(spots);
			} else if (spotType instanceof MediumSpot) {
				Map<String, MediumSpot> spots = spotList.stream().map(spot -> (MediumSpot) spot)
						.collect(Collectors.toMap(MediumSpot::getNumber, i -> i));
				floor.setMediumSpots(spots);
			} else if (spotType instanceof LargeSpot) {
				Map<String, LargeSpot> spots = spotList.stream().map(spot -> (LargeSpot) spot)
						.collect(Collectors.toMap(LargeSpot::getNumber, i -> i));
				floor.setLargeSpots(spots);
			}

		}

	}

	public void addEntrance(EntrancePoint entrance) {

		if (entrances == null)
			entrances = new HashMap<String, EntrancePoint>();

		entrances.putIfAbsent(entrance.getId(), entrance);

	}

	public void addExitPoints(ExitPoint exit) {

		if (exitPoints == null)
			exitPoints = new HashMap<>();

		exitPoints.putIfAbsent(exit.getId(), exit);

	}

	public void addAttendantToExitPoint(String exitId, Attendant attendant) {

		ExitPoint exitPoint = exitPoints.get(exitId);

		if (exitPoint != null) {
			exitPoint.setAttendant(attendant);
		}

	}

}
