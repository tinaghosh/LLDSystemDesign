package models;

public class Customer extends Person {

    private String customerId;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    //Methods

    public void placeOrder(Order order){
        System.out.println("Customer " + customerId + " placed order " + order.getOrderId()+" successfully");
    }

    public void receiveNotification(Notification notification){
        System.out.println("Customer " + customerId +
                " received notification for order " + notification.getOrderId());
    }

    public void initiateReturnRequest(Order order){
        System.out.println("Customer " + customerId + " requested return for order " + order.getOrderId());
    }

}
