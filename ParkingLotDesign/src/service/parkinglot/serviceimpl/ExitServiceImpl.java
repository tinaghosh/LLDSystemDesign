package service.parkinglot.serviceimpl;

import controller.ParkingLotController;
import entity.config.ParkingTicketStatus;
import entity.config.PaymentStatus;
import entity.parkinglot.Exit;
import entity.parkinglot.ParkingTicket;
import entity.payment.Cash;
import entity.payment.CreditCard;
import entity.payment.Payment;
import service.parkinglot.ExitService;

import java.util.Date;

public class ExitServiceImpl implements ExitService {

    @Override
    public ParkingTicket validateTicket(Exit GateNo, ParkingTicket ticket) {

        Date exitTime = new Date();
        ticket.setExitTime(exitTime);
        double duration =  (ticket.getExitTime().getTime() - ticket.getEntryTime().getTime())/ 3600000.0;
        double fee = ParkingLotController.getInstance().paymentService.calculatePaymentRate(duration,ticket.getVehicle(),ticket.getParkingSpot());
        ticket.setPakingFee(fee);
        Payment payBy;
        if(ticket.getPakingFee()>10){
            payBy = new CreditCard(fee);
        }else{
            payBy = new Cash(fee);
        }
        ticket.setPayment(payBy);
        if(ParkingLotController.getInstance().paymentService.initiateTransaction()){
            payBy.setPaymentStatus(PaymentStatus.PAID);
        }else{
            payBy.setPaymentStatus(PaymentStatus.UNPAID);
        }
        if(PaymentStatus.PAID.equals(payBy.getPaymentStatus())){
            ticket.setParkingTicketStatus(ParkingTicketStatus.PAID);
        }
        ParkingLotController.getInstance().freeSlot(ticket.getParkingSpot());
        return ticket;
    }
}
