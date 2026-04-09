package models.product;

import models.account.Account;

import java.util.List;

public class Product {

    private String productId;
    private String name;
    private byte[] image;
    private String descriptions;
    private ProductCategory category;
    private int availableQuantity;
    private double price;
    private List<ProductReviews> reviews;
    private Account sellBy;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public int getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(int availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<ProductReviews> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProductReviews> reviews) {
        this.reviews = reviews;
    }

    public Account getSellBy() {
        return sellBy;
    }

    public void setSellBy(Account sellBy) {
        this.sellBy = sellBy;
    }
}
