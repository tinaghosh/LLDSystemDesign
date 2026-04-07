package models;

import enumerations.LockerSize;
import enumerations.LockerState;

public class Locker {

    private String lockerId;
    private LockerLocation lockerLocation;
    private LockerSize lockerSize;
    private LockerState lockerState;
    private LockerPackage currentPackage;


    public String getLockerId() {
        return lockerId;
    }

    public void setLockerId(String lockerId) {
        this.lockerId = lockerId;
    }

    public LockerLocation getLockerLocation() {
        return lockerLocation;
    }

    public void setLockerLocation(LockerLocation lockerLocation) {
        this.lockerLocation = lockerLocation;
    }

    public LockerSize getLockerSize() {
        return lockerSize;
    }

    public void setLockerSize(LockerSize lockerSize) {
        this.lockerSize = lockerSize;
    }

    public LockerState getLockerState() {
        return lockerState;
    }

    public void setLockerState(LockerState lockerState) {
        this.lockerState = lockerState;
    }

    public LockerPackage getCurrentPackage() {
        return currentPackage;
    }

    public void setCurrentPackage(LockerPackage currentPackage) {
        this.currentPackage = currentPackage;
    }

    //Methods
    public boolean addPackage(LockerPackage lockerPackage){
       if(getLockerState()==LockerState.AVAILABLE) {
           setCurrentPackage(lockerPackage);
           setLockerState(LockerState.OCCUPIED);
           System.out.println("Package " + lockerPackage.getItemPackage().getPackageId() + " added to locker " + lockerId);
           return true;
       }else{
           System.out.println("Locker " + lockerId + " is not available.");
           return false;
       }
    }

    public boolean removePackage(){
        if(getLockerState()!=LockerState.OCCUPIED && getCurrentPackage()==null){
            System.out.println("Locker " + lockerId + " has no package to remove.");
            return false;
        }
        System.out.println("Package " + currentPackage.getItemPackage().getPackageId() + " removed from locker " + lockerId);
        setLockerState(LockerState.AVAILABLE);
        setCurrentPackage(null);
        return true;
    }
}
