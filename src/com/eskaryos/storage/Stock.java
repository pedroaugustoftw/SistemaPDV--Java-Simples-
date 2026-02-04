package com.eskaryos.storage;

import com.eskaryos.products.Brand;
import com.eskaryos.products.Product;
import com.eskaryos.products.Type;

import java.util.HashMap;

public class Stock {

    private HashMap<String, Product> stock;

    public Stock() {
        stock = new HashMap<>();
    }

    public void createStockProduct(Product product) {
        stock.put(product.getId(),product);
    }

    public Product getProductByName(String name) {
        for (Product p : stock.values()) {
            if(p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }
    public Product getProductById(String id) {
        if(stock.containsKey(id)) {
            return stock.get(id);
        }
        return null;
    }
    public void addProductStock(String id, int value) {
        if(stock.containsKey(id)) {
            stock.get(id).addStock(value);
        }
    }
    public boolean removeProductStock(String id, int value) {
        if(stock.containsKey(id)) {
            if(stock.get(id).getStock() >0) {
                stock.get(id).removeStock(value);
                return true;
            }
        }
        return false;
    }
    public void changeProductStockPrice(String id, double price){
        if(stock.containsKey(id)){
            stock.get(id).setPrice(price);
        }
    }
    public void changeProductName(String id, String name){
        if(stock.containsKey(id)){
            stock.get(id).setName(name);
        }
    }
    public void changeProductDescription(String id, String desc){
        if(stock.containsKey(id)){
            stock.get(id).setDescription(desc);
        }
    }
    public void changeProductType(String id, Type type){
        if(stock.containsKey(id)){
            stock.get(id).setType(type);
        }
    }
    public void changeProductType(String id, Brand brand){
        if(stock.containsKey(id)){
            stock.get(id).setBrand(brand);
        }
    }
}
