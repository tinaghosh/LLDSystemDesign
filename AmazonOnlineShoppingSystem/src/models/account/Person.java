package models.account;

import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private String phoneNo;
    private String email;
    private List<Address> address;

    public Person(String name, String phoneNo, String email, Address address) {
        this.name = name;
        this.phoneNo = phoneNo;
        this.email = email;
        this.address = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public List<Address> getAddress() {
        return address;
    }
}
