package models.atmmachine;

import Controller.ATMServiceController;

public class CashDespenser {

    public boolean dispenseCash(int amount,ATMServiceController atm){

        int originalAmount = amount;

        if(amount>0 && amount<=atm.getAtmBalance()){
            int hundreds = Math.min(amount/100, atm.getNoOfHundredDollarsNote());
            amount = amount-(hundreds*100);
            int fifties = Math.min(amount/50, atm.getNoOfFiftyDollarsNote());
            amount = amount -(fifties*50);
            int tens = Math.min(amount/10, atm.getNoOfTenDollarsNote());
            amount = amount-(tens*10);

            if(amount==0){
                atm.setNoOfHundredDollarsNote(atm.getNoOfHundredDollarsNote()-hundreds);
                atm.setNoOfFiftyDollarsNote(atm.getNoOfFiftyDollarsNote()-fifties);
                atm.setNoOfTenDollarsNote(atm.getNoOfTenDollarsNote()-tens);
                atm.setAtmBalance(atm.getAtmBalance()-originalAmount);

                System.out.println("[ATM] Dispensing $" + originalAmount + " as: " +
                        hundreds + "x$100, " + fifties + "x$50, " + tens + "x$10.");

                return true;
            }
        }
        System.out.println("[ATM] Unable to dispense the requested cash. Insufficient bills or balance.");
        return false;
    }
}
