package entity.payment;

import entity.config.PaymentStatus;
import entity.parkinglot.Exit;

import java.util.Date;

public class Payment {

    private Exit exit;
    private double amount;
    private PaymentStatus paymentStatus;
    private Date paymentTime;

    public Payment(double ammount){
        this.amount = ammount;
    }

    public Exit getExit() {
        return exit;
    }

    public void setExit(Exit exit) {
        this.exit = exit;
    }

    public double getAmmount() {
        return amount;
    }

    public void setAmmount(double ammount) {
        this.amount = ammount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }
}
