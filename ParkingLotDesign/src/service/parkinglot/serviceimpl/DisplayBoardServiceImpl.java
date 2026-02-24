package service.parkinglot.serviceimpl;

import entity.parkinglot.DisplayBoard;
import entity.parkingspot.ParkingSpot;
import service.parkinglot.DisplayBoardService;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class DisplayBoardServiceImpl implements DisplayBoardService {

    @Override
    public void updateDisplay(Collection<ParkingSpot> spots , DisplayBoard d) {
        d.getAvailableParkingSpot().clear();
        Map<String, Integer> updatedDisplay = new HashMap<>();
        for(ParkingSpot spot: spots){
            if(!spot.isOccupied()) {
                String spotType = spot.getClass().getSimpleName();
                if (updatedDisplay.containsKey(spotType)) {
                    updatedDisplay.put(spotType, updatedDisplay.get(spotType) + 1);
                } else {
                    updatedDisplay.put(spotType, 1);
                }
            }
        }
        d.setAvailableParkingSpot(updatedDisplay);
    }

    @Override
    public void showFreeSlot(DisplayBoard d) {
        System.out.println("\nFree slots by type:\n");
        d.getAvailableParkingSpot().entrySet().forEach(e-> System.out.println(e.getKey()+"  --------->  "+e.getValue()));
    }
}
