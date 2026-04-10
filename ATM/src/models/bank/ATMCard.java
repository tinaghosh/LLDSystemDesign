package models.bank;

public class ATMCard {

    private int cardNumber;
    private String nameOnCard;
    private int pinCode;
    private String expDate;

    public ATMCard(int cardNumber, String nameOnCard, int pinCode, String expDate) {
        this.cardNumber = cardNumber;
        this.nameOnCard = nameOnCard;
        this.pinCode = pinCode;
        this.expDate = expDate;
    }

    public void setPinCode(int pinCode) {
        this.pinCode = pinCode;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public int getPinCode() {
        return pinCode;
    }

    public String getExpDate() {
        return expDate;
    }

    public boolean validatePin(int pin){
        if(this.pinCode == pin ){
            return true;
        }
        return false;
    }
}
