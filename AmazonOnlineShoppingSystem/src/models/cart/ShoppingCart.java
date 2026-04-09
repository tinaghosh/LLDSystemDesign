package models.cart;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<CartItem> listOfItems = new ArrayList<>();
    private double totalCartValue;

    public List<CartItem> getListOfItems() {
        return listOfItems;
    }

    public void setListOfItems(List<CartItem> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public double getTotalCartValue() {
        return totalCartValue;
    }

    public void setTotalCartValue(double totalCartValue) {
        this.totalCartValue = totalCartValue;
    }

    public boolean addItemToCart(CartItem cartItem){
        listOfItems.add(cartItem);
        totalCartValue = totalCartValue + (cartItem.getTotalPrice());
        return true;
    }

    public boolean deleteItemFromCart(CartItem cartItem){
        if(listOfItems.remove(cartItem)) {
            totalCartValue = totalCartValue - (cartItem.getTotalPrice());
            return true;
        }
        return false;
    }

    public boolean verify(){
        return listOfItems!=null && listOfItems.isEmpty();
    }

    public boolean checkout(){
        System.out.println("Checkout complete.");
        return true;
    }
}
