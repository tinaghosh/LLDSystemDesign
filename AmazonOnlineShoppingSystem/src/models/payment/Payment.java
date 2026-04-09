package models.payment;

import enumerations.PaymentStatus;

import java.sql.Timestamp;

public abstract class Payment{

    private String transactionId;
    protected double amount;
    protected long paymentTimestamp;
    private PaymentStatus paymentStatus;
    protected String billingAddress;

    public abstract PaymentStatus makePayment();

}
