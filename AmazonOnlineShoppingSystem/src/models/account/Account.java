package models.account;

import enumerations.AccountStatus;
import models.payment.CreditCard;
import models.payment.ElectronicsBankTransfer;

import java.util.List;

public class Account{

    private String username;
    private String password;
    private Person person;
    private AccountStatus accountStatus;
    private List<CreditCard> attachedCreditCardList;
    private List<ElectronicsBankTransfer> bankTransferList;

    public String getUsername() {
        return username;
    }

    public Person getPerson() {
        return person;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public boolean addProduct(){
        return true;
    }

    public boolean deleteProduct(){
        return true;
    }

    public boolean addProductReview(){
        return true;
    }

    public boolean deleteProductReview(){
        return true;
    }

    public boolean resetPassword(){
        return true;
    }

}
