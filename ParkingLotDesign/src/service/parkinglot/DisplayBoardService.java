package service.parkinglot;

import entity.parkinglot.DisplayBoard;
import entity.parkingspot.ParkingSpot;

import java.util.Collection;

public interface DisplayBoardService {

    public void updateDisplay(Collection<ParkingSpot> spots , DisplayBoard d);
    public void showFreeSlot(DisplayBoard d);
}
