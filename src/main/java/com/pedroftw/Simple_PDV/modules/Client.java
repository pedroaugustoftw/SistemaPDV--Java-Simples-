package com.pedroftw.Simple_PDV.modules;


import com.pedroftw.Simple_PDV.infrastructure.entity.Product;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.*;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String name;

    @ManyToMany
    @JoinTable(name = "client_purchases", joinColumns = @JoinColumn(name = "client_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> lastShopping = new ArrayList<>();

    private LocalDate lastShoppingDate;

    public Client(){}

    public String getId() { return id; }

    public void addProduct(Product p) {
        this.lastShopping.add(p);
        this.lastShoppingDate = LocalDate.now(); // Atualiza a data automaticamente
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
