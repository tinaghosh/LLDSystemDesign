package models.atmoperations;

import Controller.ATMServiceController;
import atmservice.ATMOperationsService;
import models.bank.BankAccount;
import models.enumerations.ATMState;

public class TransferMoneyState extends ATMOperationsService {
    @Override
    public void fundTransfer(ATMServiceController atm, BankAccount toAccount, Double amount) {

        BankAccount fromAccount = atm.getActiveUser().getBankAccount();
        double accountLimit = fromAccount.getWithdrawLimit();
        if(amount <= accountLimit && amount <= fromAccount.getAvailableBalance()){
            boolean transferred = fromAccount.transfer(toAccount,amount);
            if(transferred){
                atm.getPrinter().printReceipt("Transferred: $" + amount +
                        " from Acc# "+fromAccount.getBankAccountNo() + " to Acc# "+toAccount.getBankAccountNo() +
                        " | Your balance: $" + fromAccount.getAvailableBalance());

                atm.getScreen().showMessage("Transfer successful.");
            }else{
                atm.getScreen().showMessage("Transfer failed.");
            }
        }else{
            atm.getScreen().showMessage("Transfer denied. Check your balance or limits.");
        }
        // Return to selection state
        atm.setAtmServiceState(new SelectionOptionsState());
        atm.setCurrentState(ATMState.SELECTION_OPTIONS);
    }
}
