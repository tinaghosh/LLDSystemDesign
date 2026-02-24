package entity.admin;

import entity.config.AccountStatus;
import entity.config.AccountType;

public class Account {

    private String username;
    private String password;
    private Person person;
    private AccountStatus accountStatus;
    private AccountType accountType;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public entity.config.AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(entity.config.AccountStatus accountStatus) {
        accountStatus = accountStatus;
    }
}
