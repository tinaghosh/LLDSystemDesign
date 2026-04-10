package models.atmoperations;

import Controller.ATMServiceController;
import atmservice.ATMOperationsService;
import models.enumerations.ATMServiceType;
import models.enumerations.ATMState;

public class SelectionOptionsState extends ATMOperationsService {
    @Override
    public void selectOptions(ATMServiceController atm, ATMServiceType type) {

        if(type == ATMServiceType.BALANCE_ENQUIRY){
            atm.setCurrentState(ATMState.BALANCE_ENQUIRY);
            atm.setAtmServiceState(new BalanceEnquiryState());
        }else if (type == ATMServiceType.CASH_WITHDRAW){
            atm.setCurrentState(ATMState.CASH_WITHDRAW);
            atm.setAtmServiceState(new CashWithdrawalState());
        }else if (type == ATMServiceType.FUND_TRANSFER){
            atm.setCurrentState(ATMState.FUND_TRANSFER);
            atm.setAtmServiceState(new TransferMoneyState());
        }else if (type == ATMServiceType.CHANGE_PIN){
            atm.setCurrentState(ATMState.CHANGE_PIN);
            atm.setAtmServiceState(new ChangePinState());
        }else{
            atm.getAtmServiceState().returnCard(atm);
        }
    }
}
