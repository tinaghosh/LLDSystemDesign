package models.atmoperations;

import Controller.ATMServiceController;
import atmservice.ATMOperationsService;
import models.enumerations.ATMState;

public class BalanceEnquiryState extends ATMOperationsService {
    @Override
    public void displayBalance(ATMServiceController atm) {
       atm.getScreen().showMessage("Your current balance is: $" +
               atm.getActiveUser().getBankAccount().getAvailableBalance());

       atm.getPrinter().printReceipt("Balance: $" +
               atm.getActiveUser().getBankAccount().getAvailableBalance());

        // Return to selection state
        atm.setAtmServiceState(new SelectionOptionsState());
        atm.setCurrentState(ATMState.SELECTION_OPTIONS);

    }
}
