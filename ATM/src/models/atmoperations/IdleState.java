package models.atmoperations;

import Controller.ATMServiceController;
import atmservice.ATMOperationsService;
import models.bank.ATMCard;
import models.enumerations.ATMState;

public class IdleState extends ATMOperationsService {
    @Override
    public void insertCard(ATMServiceController atm, ATMCard atmCard) {
      if(atm.getCardReader().readCard(atmCard)){
         atm.setInsertedCard(atmCard);
         atm.setCurrentState(ATMState.CARD_INSERTED);
         atm.setAtmServiceState(new CardInsertedAndReturnState());
         atm.getScreen().showMessage("Please enter your PIN:");
      }else{
          atm.getScreen().showMessage("Card reading failed.");
      }
    }
}
