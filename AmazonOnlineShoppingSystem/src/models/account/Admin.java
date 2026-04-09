package models.account;

import models.product.ProductCategory;

public class Admin {

    private Account admin;

    public Admin(Account admin) {
        this.admin = admin;
    }

    public boolean blockUser(){
        return true;
    }

    public boolean addNewProductCategory(ProductCategory productCategory){
        return true;
    }

    public boolean modifyProductCategory(ProductCategory productCategory){
        return true;
    }

    public boolean deleteProductCategory(ProductCategory productCategory){
        return true;
    }
}
