package models.account;

import models.product.Product;
import models.search.Search;

import java.util.List;

public class Guest extends Customer{

    @Override
    public List<Product> search(String name) {
        Search search = new Search();
        return search.wildSearchProductByProductName(name);
    }

    public boolean registerAccount(String username, String password, String email, String phoneNo){
        System.out.println("Account registered for user: " + username);
        return true;
    }
}
