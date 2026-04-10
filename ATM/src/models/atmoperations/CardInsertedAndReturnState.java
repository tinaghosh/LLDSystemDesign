package models.atmoperations;

import Controller.ATMServiceController;
import atmservice.ATMOperationsService;
import models.enumerations.ATMState;

public class CardInsertedAndReturnState extends ATMOperationsService {

    @Override
    public void authenticatePin(ATMServiceController atm, int pin) {
       if(atm.getInsertedCard().validatePin(pin)){
           atm.setAuthenticated(true);
           atm.setCurrentState(ATMState.SELECTION_OPTIONS);
           atm.setAtmServiceState(new SelectionOptionsState());
           atm.getScreen().showMessage("PIN verified. Please select a option.");
       }else{
           atm.getScreen().showMessage("Incorrect PIN. Please try again or cancel.");
       }
    }

    @Override
    public void returnCard(ATMServiceController atm) {
        atm.setInsertedCard(null);
        atm.setActiveUser(null);
        atm.setAuthenticated(false);
        atm.setCurrentState(ATMState.IDLE);
        atm.setAtmServiceState(new IdleState());
        atm.getScreen().showMessage("Card returned. Thank you.");
    }
}
