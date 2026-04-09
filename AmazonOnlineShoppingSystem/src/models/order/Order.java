package models.order;

import enumerations.OrderStatus;
import enumerations.PaymentStatus;
import models.account.AuthenticatedUser;
import models.cart.CartItem;
import models.cart.ShoppingCart;
import models.payment.Payment;

import java.util.Date;

public class Order {

    private String orderId;
    private ShoppingCart shoppingCart;
    private AuthenticatedUser orderPlacedBy;
    private Date orderDate;
    private OrderStatus orderStatus;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public AuthenticatedUser getOrderPlacedBy() {
        return orderPlacedBy;
    }

    public void setOrderPlacedBy(AuthenticatedUser orderPlacedBy) {
        this.orderPlacedBy = orderPlacedBy;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean sendForShipment(){
        return true;
    }

    public PaymentStatus makePayment(Payment payment){
        return payment.makePayment();
    }

    public boolean verify(CartItem cartItem){
        return (cartItem!=null && cartItem.getQuantity()>0 && cartItem.getProduct()!=null);
    }
}
