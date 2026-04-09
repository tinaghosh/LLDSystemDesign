package models.payment;

import enumerations.PaymentStatus;


import java.time.Instant;

public class CashOnDelivery extends Payment{

    public CashOnDelivery(Double amount, String billingAddress){
        this.amount = amount;
        this.paymentTimestamp = Instant.now().toEpochMilli();
        this.billingAddress = billingAddress;
    }

    @Override
    public PaymentStatus makePayment() {
        System.out.println("Processing cash payment of $" + amount);
        return PaymentStatus.CONFIRMED;
    }
}
