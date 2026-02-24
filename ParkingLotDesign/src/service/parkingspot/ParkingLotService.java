package service.parkingspot;

import entity.parkingspot.ParkingSpot;
import entity.vehicle.Vehicle;

public interface ParkingLotService {

    public void assignVehicle(Vehicle v , ParkingSpot spot);
    public void removeVehicle(ParkingSpot spot);

}
