package models.product;

import enumerations.ProductCategoryType;

import java.util.List;

public class ProductCategory {

    private ProductCategoryType name;
    private String description;
    private List<Product> productList;

    public ProductCategoryType getName() {
        return name;
    }

    public void setName(ProductCategoryType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
