package models.atmoperations;

import Controller.ATMServiceController;
import atmservice.ATMOperationsService;
import models.enumerations.ATMState;

public class ChangePinState extends ATMOperationsService {
    @Override
    public void changePin(ATMServiceController atm, int newPin) {
      atm.getInsertedCard().setPinCode(newPin);
      atm.getPrinter().printReceipt("PIN changed successfully.");
      atm.getScreen().showMessage("PIN changed.");

      // Return to selection state
      atm.setAtmServiceState(new SelectionOptionsState());
      atm.setCurrentState(ATMState.SELECTION_OPTIONS);
    }
}
