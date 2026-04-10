package models.atmoperations;

import Controller.ATMServiceController;
import atmservice.ATMOperationsService;
import models.enumerations.ATMState;

public class CashWithdrawalState extends ATMOperationsService {
    @Override
    public void cashWithdraw(ATMServiceController atm, double amount) {
        if(amount%10!=0){
            atm.getScreen().showMessage("Unable to dispense the requested amount." +
                    "Has to be divisible by 10");
        }else {
            if (amount <= atm.getAtmBalance() && amount <= atm.getActiveUser().getBankAccount().getAvailableBalance()
                    && amount <= atm.getActiveUser().getBankAccount().getWithdrawLimit()) {
                boolean dispense = atm.getCashDespenser().dispenseCash((int) amount, atm);

                if (dispense) {
                    atm.getActiveUser().getBankAccount().cashWithDraw(amount);
                    atm.getPrinter().printReceipt("Withdrawn: $" + amount + " | Remaining balance: $" +
                            atm.getActiveUser().getBankAccount().getAvailableBalance());
                    atm.getScreen().showMessage("Please collect your cash.");
                } else {
                    atm.getScreen().showMessage("Unable to dispense the requested amount.");
                }
            } else {
                atm.getScreen().showMessage("Withdrawal denied. Check your balance or limits.");
            }
        }

        // Return to selection state
        atm.setAtmServiceState(new SelectionOptionsState());
        atm.setCurrentState(ATMState.SELECTION_OPTIONS);
    }
}
