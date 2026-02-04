package com.eskaryos.modules;

import com.eskaryos.products.Product;

import java.time.LocalDate;
import java.util.*;

public class Client {

    private String name;
    private List<Product> lastShopping;
    private LocalDate lastShoppingDate;

    public Client(String name) {
        this.name = name;
        this.lastShopping = new ArrayList<>();
    }
    public void setLastShopping(List<Product> lastShopping) {this.lastShopping = lastShopping;}
    public LocalDate getLastShoppingDate(){
        return lastShoppingDate;
    }
    public void setLastShoppingDate(LocalDate lastShoppingDate){this.lastShoppingDate = lastShoppingDate;}
    public List<Product> getLastShoppingProducts(){
        return lastShopping;
    }
    public void addProduct(Product p, int qnt) {
        lastShopping.add(p);
    }
    public void removeProduct(Product p, int qnt) {
        lastShopping.remove(p);
    }

    public List<Product> getLastShopping(){
        return lastShopping;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

}
