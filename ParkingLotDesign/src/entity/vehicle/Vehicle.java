package entity.vehicle;

import entity.parkinglot.ParkingTicket;

public class Vehicle{

    private String licenseNo;
    private ParkingTicket parkingTicket;
    private boolean havingDisableStricker;

    public Vehicle(String licenseNo , boolean havingDisableStricker){
        this.licenseNo = licenseNo;
        this.havingDisableStricker = havingDisableStricker ;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public ParkingTicket getParkingTicket() {
        return parkingTicket;
    }

    public void setParkingTicket(ParkingTicket parkingTicket) {
        this.parkingTicket = parkingTicket;
    }

    public boolean isHavingDisableStricker() {
        return havingDisableStricker;
    }

    public void setHavingDisableStricker(boolean havingDisableStricker) {
        this.havingDisableStricker = havingDisableStricker;
    }
}
