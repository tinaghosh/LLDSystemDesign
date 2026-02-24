package service.parkinglot;

import entity.parkinglot.Entrance;
import entity.parkinglot.ParkingTicket;
import entity.parkingspot.ParkingSpot;
import entity.vehicle.Vehicle;

import java.util.Collection;

public interface EntranceService {

    public ParkingTicket getTicket(Entrance e , Vehicle v, Collection<ParkingSpot> parkingSpots);
}
