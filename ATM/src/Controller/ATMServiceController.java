package Controller;

import atmservice.ATMOperationsService;
import models.atmmachine.*;
import models.atmoperations.IdleState;
import models.bank.ATMCard;
import models.enumerations.ATMState;
import models.user.User;

public class ATMServiceController {
    private static ATMServiceController instance;

    private CardReader cardReader;
    private KeyPad keyPad;
    private CashDespenser cashDespenser;
    private Screen screen;
    private Printer printer;

    private ATMOperationsService atmServiceState;
    private ATMState currentState;

    private double atmBalance;
    private int noOfHundredDollarsNote;
    private int noOfFiftyDollarsNote;
    private int noOfTenDollarsNote;

    //Session Based objects
    private User activeUser;
    private ATMCard insertedCard;
    private boolean authenticated;


    public ATMServiceController(){
        this.atmServiceState = new IdleState();
        this.currentState = ATMState.IDLE;
        this.screen = new Screen();
        this.keyPad = new KeyPad();
        this.cardReader = new CardReader();
        this.cashDespenser = new CashDespenser();
        this.printer = new Printer();
    }

    public void setUpATMBalanceAndSession(double amount, int noOfHundredDollarsNote, int noOfFiftyDollarsNote, int noOfTenDollarsNote){

        this.atmBalance = amount;
        this.noOfHundredDollarsNote = noOfHundredDollarsNote;
        this.noOfFiftyDollarsNote = noOfFiftyDollarsNote;
        this.noOfTenDollarsNote = noOfTenDollarsNote;

        //session based variable initialization
        this.activeUser = null;
        this.insertedCard = null;
        this.authenticated = false;

    }

    public static ATMServiceController getInstance(){
        if(instance==null){
            instance = new ATMServiceController();
        }
        return instance;
    }

    public static void setInstance(ATMServiceController instance) {
        ATMServiceController.instance = instance;
    }

    public CardReader getCardReader() {
        return cardReader;
    }

    public void setCardReader(CardReader cardReader) {
        this.cardReader = cardReader;
    }

    public KeyPad getKeyPad() {
        return keyPad;
    }

    public void setKeyPad(KeyPad keyPad) {
        this.keyPad = keyPad;
    }

    public CashDespenser getCashDespenser() {
        return cashDespenser;
    }

    public void setCashDespenser(CashDespenser cashDespenser) {
        this.cashDespenser = cashDespenser;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    public ATMOperationsService getAtmServiceState() {
        return atmServiceState;
    }

    public void setAtmServiceState(ATMOperationsService atmServiceState) {
        this.atmServiceState = atmServiceState;
    }

    public ATMState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(ATMState currentState) {
        this.currentState = currentState;
    }

    public double getAtmBalance() {
        return atmBalance;
    }

    public void setAtmBalance(double atmBalance) {
        this.atmBalance = atmBalance;
    }

    public int getNoOfHundredDollarsNote() {
        return noOfHundredDollarsNote;
    }

    public void setNoOfHundredDollarsNote(int noOfHundredDollarsNote) {
        this.noOfHundredDollarsNote = noOfHundredDollarsNote;
    }

    public int getNoOfFiftyDollarsNote() {
        return noOfFiftyDollarsNote;
    }

    public void setNoOfFiftyDollarsNote(int noOfFiftyDollarsNote) {
        this.noOfFiftyDollarsNote = noOfFiftyDollarsNote;
    }

    public int getNoOfTenDollarsNote() {
        return noOfTenDollarsNote;
    }

    public void setNoOfTenDollarsNote(int noOfTenDollarsNote) {
        this.noOfTenDollarsNote = noOfTenDollarsNote;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }

    public ATMCard getInsertedCard() {
        return insertedCard;
    }

    public void setInsertedCard(ATMCard insertedCard) {
        this.insertedCard = insertedCard;
    }

    public boolean isAuthenticated() {
        return authenticated;
    }

    public void setAuthenticated(boolean authenticated) {
        this.authenticated = authenticated;
    }
}
