package models.atmmachine;

import models.bank.ATMCard;

public class CardReader {

    public boolean readCard(ATMCard card){
        if(card!=null) {
            System.out.println("[ATM] Reading card: " + card.getNameOnCard()
                    +"--->"+card.getCardNumber());
            return true;
        }
        return false;
    }
}
