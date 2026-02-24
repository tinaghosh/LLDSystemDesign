package service.payment;

import entity.parkingspot.ParkingSpot;
import entity.vehicle.Vehicle;

public interface PaymentService {

    public double calculatePaymentRate(double durationInHours, Vehicle v, ParkingSpot spot);
    public boolean initiateTransaction();
}
