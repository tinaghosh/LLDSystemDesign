package models.bankaccounttype;

import models.bank.BankAccount;

public class SavingsAccount extends BankAccount {

    public SavingsAccount(int bankAccountNo, double availableBalance){
        super(bankAccountNo, availableBalance);
    }
    @Override
    public double getWithdrawLimit() {
        return 1000.0;
    }
}
