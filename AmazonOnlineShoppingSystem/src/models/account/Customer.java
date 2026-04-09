package models.account;

import models.product.Product;

import java.util.List;

public abstract class Customer {

    public abstract List<Product> search(String name);
}
