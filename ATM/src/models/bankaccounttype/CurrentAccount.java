package models.bankaccounttype;

import models.bank.BankAccount;

public class CurrentAccount extends BankAccount {

    public CurrentAccount(int bankAccountNo, double availableBalance){
        super(bankAccountNo, availableBalance);
    }

    @Override
    public double getWithdrawLimit() {
        return 5000.0;
    }
}
