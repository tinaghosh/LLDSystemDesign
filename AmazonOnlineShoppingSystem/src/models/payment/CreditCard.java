package models.payment;

import enumerations.PaymentStatus;

import java.time.Instant;

public class CreditCard extends Payment{

    private String nameOnTheCard;
    private int carNumber;
    private int code;

    public CreditCard(String nameOnTheCard, int carNumber, int code ,
                      String billingAddress, double amount) {
        this.nameOnTheCard = nameOnTheCard;
        this.carNumber = carNumber;
        this.code = code;
        this.billingAddress = billingAddress;
        this.amount = amount;
        this.paymentTimestamp = Instant.now().toEpochMilli();
    }

    @Override
    public PaymentStatus makePayment() {
        System.out.println("Processing credit card payment for " + amount);
        return PaymentStatus.CONFIRMED;
    }

}
