package models;

import java.util.Date;
import java.util.List;

public class LockerLocation {

    private String locationName;
    private List<Locker> lockerList;
    private Address locationAddress;
    private double latitude;
    private double longitude;
    private Date openTime;
    private Date closeTime;

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public List<Locker> getLockerList() {
        return lockerList;
    }

    public void setLockerList(List<Locker> lockerList) {
        this.lockerList = lockerList;
    }

    public Address getLocationAddress() {
        return locationAddress;
    }

    public void setLocationAddress(Address locationAddress) {
        this.locationAddress = locationAddress;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Date getOpenTime() {
        return openTime;
    }

    public void setOpenTime(Date openTime) {
        this.openTime = openTime;
    }

    public Date getCloseTime() {
        return closeTime;
    }

    public void setCloseTime(Date closeTime) {
        this.closeTime = closeTime;
    }

    //Methods

    public void addLocker(Locker locker){
        this.lockerList.add(locker);
    }
}
