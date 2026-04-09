package models.payment;

import enumerations.PaymentStatus;

import java.time.Instant;

public class ElectronicsBankTransfer extends  Payment{

    private String bankName;
    private int accountNo;
    private String IFSCCode;

    public ElectronicsBankTransfer(String bankName, int accountNo, String IFSCCode ,
                                   String billingAddress, double amount) {
        this.bankName = bankName;
        this.accountNo = accountNo;
        this.IFSCCode = IFSCCode;
        this.billingAddress = billingAddress;
        this.amount = amount;
        this.paymentTimestamp = Instant.now().toEpochMilli();
    }

    @Override
    public PaymentStatus makePayment() {
        System.out.println("Processing bank transfer for " + amount);
        return PaymentStatus.CONFIRMED;
    }
}
