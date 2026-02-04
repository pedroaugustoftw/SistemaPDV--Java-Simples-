package com.eskaryos.modules;

import com.eskaryos.PDVMain;
import com.eskaryos.products.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SellerModule {

    private User seller;
    private Client client;
    private List<Product> productList;
    private LocalDate date;
    private PaymentMethod method;
    private double totalPrice;

    public SellerModule (User seller){
        this.seller = seller;
        this.productList = new ArrayList<>();
        this.date = LocalDate.now();
        this.totalPrice = 0.0;
    }
    public void newModule(){
        this.totalPrice = 0.0;
        this.setPaymentMethod(null);
        this.date = LocalDate.now();
        this.productList = new ArrayList<>();
        this.client = null;
    }
    public void newModule(Client client){
        this.totalPrice = 0.0;
        this.setPaymentMethod(null);
        this.date = LocalDate.now();
        this.productList = new ArrayList<>();
        this.client = client;
    }
    public void newModule(User user){
        this.totalPrice = 0.0;
        this.setPaymentMethod(null);
        this.date = LocalDate.now();
        this.productList = new ArrayList<>();
        this.client = null;
        this.seller = user;
    }
    public void newModule(Client client,User user){
        this.totalPrice = 0.0;
        this.setPaymentMethod(null);
        this.date = LocalDate.now();
        this.productList = new ArrayList<>();
        this.client = null;
        this.seller = user;
    }
    public void processModule(){
        if(this.method == null) {
            System.out.println("Seller module has no payment method");
            return;
        }
        if(client !=null){
            client.setLastShoppingDate(this.date);
            client.setLastShopping(productList);
        }
        this.totalPrice = 0.0;
        this.setPaymentMethod(null);
        this.date = null;
        this.productList = new ArrayList<>();
        this.client = null;
        System.out.println("SellerModule processModule");
    }

    public Double getTotalPrice(){
        return this.totalPrice;
    }

    public void setPaymentMethod(PaymentMethod method){
        this.method = method;
    }

    public void addProduct(Product product){
        if(PDVMain.stock.getProductById(product.getId()) != null){
            if(PDVMain.stock.removeProductStock(product.getId(),1)){
                productList.add(product);
                totalPrice += product.getPrice();
                System.out.println("[PDV] Item: " + product.getName() + " added to list");
            }else{
                System.out.println("Out of stock");
            }

        }

    }
    public void removeProduct(Product product){
        try{
            totalPrice -= product.getPrice();
            PDVMain.stock.addProductStock(product.getId(),1);
            productList.remove(product);
        }catch(Exception e){
            System.out.println("Error on remove product of list.");
        }

    }

    public void addClient(Client client){
        this.client = client;
    }
}
