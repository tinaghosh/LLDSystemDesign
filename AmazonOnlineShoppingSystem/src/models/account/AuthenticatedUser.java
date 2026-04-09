package models.account;

import enumerations.OrderStatus;
import models.cart.CartItem;
import models.cart.ShoppingCart;
import models.order.Order;
import models.product.Product;
import models.search.Search;

import java.util.List;

public class AuthenticatedUser extends Customer{

    private Account account;
    private Order order;
    private ShoppingCart shoppingCart;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public List<Product> search(String name) {
        Search search = new Search();
        return search.wildSearchProductByProductName(name);
    }

    public boolean addItemToShoppingCart(Product product, int quantity){
        CartItem item = new CartItem();
        item.setProduct(product);
        item.setQuantity(quantity);
        return getShoppingCart().addItemToCart(item);
    }

    public ShoppingCart getShoppingCart(){
        if(this.shoppingCart == null){
            shoppingCart = new ShoppingCart();
        }
      return this.shoppingCart;
    }

    public OrderStatus placeOrder(CartItem item, double amount){
        // Logic to place an order
        System.out.println("Placing order for item: " + item.getProduct().getName() + " Amount: $" + amount);
        return OrderStatus.PENDING_PAYMENT;
    }

    public boolean initiatePayment(double amount){
        System.out.println("Initiating payment of $" + amount);
        return true;
    }
}
