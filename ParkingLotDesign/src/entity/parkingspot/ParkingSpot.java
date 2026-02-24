package entity.parkingspot;

import entity.vehicle.Vehicle;

public class ParkingSpot {

    private int parkingSpotId;
    private Vehicle vehicle;
    private boolean isOccupied;

    public ParkingSpot(int id){
        this.parkingSpotId = id ;
    }

    public int getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(int parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}
