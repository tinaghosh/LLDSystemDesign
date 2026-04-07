package models;

import java.util.ArrayList;
import java.util.List;

public class Order{

    private String orderId;
    private List<Item> itemLists;
    private String customerId;
    private String deliveryLocation;

   public Order(){
       this.itemLists = new ArrayList<>();
   }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public List<Item> getItemLists() {
        return itemLists;
    }

    public void setItemLists(List<Item> itemLists) {
        this.itemLists = itemLists;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    //Methods
    public void addItems(Item item){
        this.itemLists.add(item);
    }
}
