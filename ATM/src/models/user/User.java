package models.user;

import models.bank.ATMCard;
import models.bank.BankAccount;

public class User{

    private String name;
    private ATMCard atmCard;
    private BankAccount bankAccount;

    public User(String name, ATMCard atmCard, BankAccount bankAccount) {
        this.name = name;
        this.atmCard = atmCard;
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public ATMCard getAtmCard() {
        return atmCard;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }
}
