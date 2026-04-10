package atmservice;

import Controller.ATMServiceController;
import models.bank.ATMCard;
import models.bank.BankAccount;
import models.enumerations.ATMServiceType;

public  class ATMOperationsService {

    public  void insertCard(ATMServiceController atm, ATMCard atmCard){}
    public  void authenticatePin(ATMServiceController atm,int pin){}
    public  void selectOptions(ATMServiceController atm, ATMServiceType type){}
    public  void cashWithdraw(ATMServiceController atm, double amount){}
    public  void changePin(ATMServiceController atm, int newPin){}
    public  void displayBalance(ATMServiceController atm){}
    public  void fundTransfer(ATMServiceController atm, BankAccount toAccount, Double amount){}
    public  void cancelTransaction(ATMServiceController atm){}
    public  void returnCard(ATMServiceController atm){}
    public  void exit(ATMServiceController atm){}

}
