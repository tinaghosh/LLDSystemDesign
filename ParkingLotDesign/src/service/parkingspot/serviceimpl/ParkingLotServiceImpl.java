package service.parkingspot.serviceimpl;

import entity.parkingspot.ParkingSpot;
import entity.vehicle.Vehicle;
import service.parkingspot.ParkingLotService;

public class ParkingLotServiceImpl implements ParkingLotService {

    @Override
    public void assignVehicle(Vehicle v , ParkingSpot spot) {
        spot.setVehicle(v);
        spot.setOccupied(true);
    }

    @Override
    public void removeVehicle(ParkingSpot spot) {
      if(spot.isOccupied() && spot.getVehicle()!=null){
          System.out.println(spot.getVehicle().getLicenseNo() + "is Leaving the Parking Spot");
          spot.setOccupied(false);
          spot.setVehicle(null);
      }
    }
}
