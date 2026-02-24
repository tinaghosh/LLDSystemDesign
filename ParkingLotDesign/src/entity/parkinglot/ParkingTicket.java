package entity.parkinglot;

import entity.config.ParkingTicketStatus;
import entity.parkingspot.ParkingSpot;
import entity.payment.Payment;
import entity.vehicle.Vehicle;

import java.util.Date;

public class ParkingTicket {

    private static int ticketSeed = 1000;
    private int parkingTicketNo;
    private Entrance entrance;
    private Date entryTime;
    private Date exitTime;
    private double pakingFee;
    private Payment payment;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;
    private ParkingTicketStatus parkingTicketStatus;

    public ParkingTicket(ParkingSpot spot, Vehicle vehicle){

        this.parkingTicketNo = ticketSeed++;
        this.parkingSpot = spot;
        this.entryTime = new Date();
        this.parkingTicketStatus = ParkingTicketStatus.ISSUED;
        this.vehicle = vehicle;
        vehicle.setParkingTicket(this);
        System.out.println("Ticket issued: " + parkingTicketNo);
    }

    public int getParkingTicketNo() {
        return parkingTicketNo;
    }

    public void setParkingTicketNo(int parkingTicketNo) {
        this.parkingTicketNo = parkingTicketNo;
    }

    public Entrance getEntrance() {
        return entrance;
    }

    public void setEntrance(Entrance entrance) {
        this.entrance = entrance;
    }

    public Date getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(Date entryTime) {
        this.entryTime = entryTime;
    }

    public Date getExitTime() {
        return exitTime;
    }

    public void setExitTime(Date exitTime) {
        this.exitTime = exitTime;
    }

    public double getPakingFee() {
        return pakingFee;
    }

    public void setPakingFee(double pakingFee) {
        this.pakingFee = pakingFee;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public ParkingTicketStatus getParkingTicketStatus() {
        return parkingTicketStatus;
    }

    public void setParkingTicketStatus(ParkingTicketStatus parkingTicketStatus) {
        this.parkingTicketStatus = parkingTicketStatus;
    }
}
