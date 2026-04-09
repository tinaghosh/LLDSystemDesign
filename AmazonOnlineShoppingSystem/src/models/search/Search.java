package models.search;

import models.product.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Search {

    private Map<String, List<Product>> productCatalog = new HashMap<>();

    public Map<String, List<Product>> getProductCatalog() {
        return productCatalog;
    }

    public void setProductCatalog(Map<String, List<Product>> productCatalog) {
        this.productCatalog = productCatalog;
    }

    public Product searchProductByProductId(String productId){
        for(List<Product> productList : productCatalog.values()){
            for(Product product : productList){
                if(productId.equals(product.getProductId())){
                    return product;
                }
            }
        }
        return null;
    }

    public List<Product> wildSearchProductByProductName(String productName){

        List<Product> listofProudctNeameWildSearch = new ArrayList<>();
        for(List<Product> productList : productCatalog.values()){
            for(Product product : productList){
                if(product.getName().contains(productName) || product.getDescriptions().contains(productName)){
                    listofProudctNeameWildSearch.add(product);
                }
            }
        }
        return listofProudctNeameWildSearch;
    }

    public List<Product> searchProductByProductCategory(String productCategory){
        return productCatalog.getOrDefault(productCategory,new ArrayList<>());
    }
}
