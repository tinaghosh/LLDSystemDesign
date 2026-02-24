package service.parkinglot.serviceimpl;

import controller.ParkingLotController;
import entity.parkinglot.Entrance;
import entity.parkinglot.ParkingTicket;
import entity.parkingspot.ParkingSpot;
import entity.vehicle.Vehicle;
import service.parkinglot.EntranceService;

import java.util.Collection;

public class EntranceServiceImpl implements EntranceService {

    @Override
    public ParkingTicket getTicket(Entrance e , Vehicle v , Collection<ParkingSpot> parkingSpots) {
        return ParkingLotController.getInstance().parkVehicle(v, parkingSpots);
    }
}
