package service.payment.serviceimpl;

import entity.parkingspot.ParkingSpot;
import entity.vehicle.Vehicle;
import service.payment.PaymentService;

import java.util.Date;

public class PaymentServiceImpl implements PaymentService {

    @Override
    public double calculatePaymentRate(double durationInHours , Vehicle v, ParkingSpot spot) {
        int hrs = (int)Math.ceil(durationInHours);
        double fee = 0;
        /* System.out.println(Math.ceil(4.2)); //5.0 (Positive Number)
        System.out.println(Math.ceil(5.0)); //5.0 (Exact Integer)
        System.out.println(Math.ceil(-4.2)); //-4.0 (Negative Number) */

        if(hrs >= 1){
            fee = fee + 4;
        }else if(hrs >=2){
            fee = fee + 3.5;
        }else if(hrs >=3){
            fee = fee + 3.0;
        }else{
            fee = fee + (hrs-3)*2.5;
        }

        return fee;
    }

    @Override
    public boolean initiateTransaction() {
      return true;
    }
}
