package controller;

import enumerations.LockerSize;
import enumerations.LockerState;
import models.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class LockerServiceController {

    private static LockerServiceController instance;
    private List<LockerLocation> locations;


    public LockerServiceController(){
        initializeLockerService();
    }

    public void initializeLockerService(){

        System.out.println("🛠️  [SETUP] ---->  Locker Location \n");

        LockerLocation lockerLocation = new LockerLocation();

        lockerLocation.setLocationName("Milpitas");
        lockerLocation.setLockerList(new ArrayList<>());
        lockerLocation.setLatitude(37.4369);
        lockerLocation.setLongitude(-121.8975);

        locations = new ArrayList<>();
        locations.add(lockerLocation);

        Calendar openCalender = Calendar.getInstance();
        openCalender.set(Calendar.HOUR_OF_DAY,9);
        lockerLocation.setOpenTime(openCalender.getTime());

        Calendar closeCalender = Calendar.getInstance();
        openCalender.set(Calendar.HOUR_OF_DAY,18);
        lockerLocation.setCloseTime(closeCalender.getTime());

        Address address = new Address("807 N McCarthy Blvd","Milpitas","CA","95035");
        lockerLocation.setLocationAddress(address);

        System.out.println("🛠️  [SETUP] ---->  Lockers \n");

        Locker locker1 = new Locker();
        locker1.setLockerId("L1");
        locker1.setLockerSize(LockerSize.MEDIUM);
        locker1.setLockerState(LockerState.AVAILABLE);
        locker1.setLockerLocation(lockerLocation);

        Locker locker2 = new Locker();
        locker2.setLockerId("L2");
        locker2.setLockerSize(LockerSize.LARGE);
        locker2.setLockerState(LockerState.AVAILABLE);
        locker2.setLockerLocation(lockerLocation);

        lockerLocation.addLocker(locker1);
        lockerLocation.addLocker(locker2);
        System.out.println("    → Added LockerLocation: Downtown with Lockers: [L1, L2]\n");

    }

    public static LockerServiceController getInstance(){
       if(instance == null){
           instance = new LockerServiceController();
       }
       return instance;
    }

    public List<LockerLocation> getLocations() {
        return locations;
    }

    public void setLocations(List<LockerLocation> locations) {
        this.locations = locations;
    }

    public List<LockerLocation> getLockersLocationBasedOnLocationName(String locationName){

        List<LockerLocation> locationWiseList = new ArrayList<>();

        for(LockerLocation location : this.getLocations()){
            if(locationName.equalsIgnoreCase(location.getLocationName())){
                locationWiseList.add(location);
            }
        }
       return locationWiseList;
    }

    public Locker requestLocker(LockerSize lockerSize , String locationName){
        for(LockerLocation location: getLockersLocationBasedOnLocationName(locationName)){
            for(Locker locker : location.getLockerList()){
                if(locker.getLockerState() == LockerState.AVAILABLE &&
                        locker.getLockerSize() == lockerSize){
                    System.out.println("Locker Assigned. LockerId -> "+locker.getLockerId());
                    return locker;
                }
            }
        }
        System.out.println("No available lockers at the moment.");
        return null;
    }

    public boolean approvalOfReturnRequested(Order order){
        System.out.println("Return request received for order: " + order.getOrderId());
        return true;
    }
}
