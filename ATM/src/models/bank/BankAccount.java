package models.bank;

public abstract class BankAccount {

    private int bankAccountNo;

    private double availableBalance;

    public BankAccount(int bankAccountNo, double availableBalance) {
        this.bankAccountNo = bankAccountNo;
        this.availableBalance = availableBalance;
    }

    public int getBankAccountNo() {
        return bankAccountNo;
    }

    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public boolean cashWithDraw(double amount){
        if(amount>0 && amount <= getAvailableBalance() && amount <= getWithdrawLimit()){
            this.setAvailableBalance(getAvailableBalance()-amount);
            return true;
        }
      return false;
    }

    public boolean transfer(BankAccount toAccount, double amount){
       if(amount>0 && amount <= getAvailableBalance() && amount <= getWithdrawLimit()){
           this.setAvailableBalance(getAvailableBalance()-amount);
           toAccount.setAvailableBalance(toAccount.getAvailableBalance()+amount);
           return true;
       }
       return false;
    }

    public abstract double getWithdrawLimit();
}
