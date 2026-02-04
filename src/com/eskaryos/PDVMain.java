package com.eskaryos;

import com.eskaryos.modules.Client;
import com.eskaryos.modules.PaymentMethod;
import com.eskaryos.modules.SellerModule;
import com.eskaryos.modules.User;
import com.eskaryos.products.Brand;
import com.eskaryos.products.Product;
import com.eskaryos.products.Type;
import com.eskaryos.storage.Stock;


public class PDVMain {

    public static Stock stock;
    public static SellerModule module;

    public static void main(String[] args) {
        stock = new Stock();
        module = new SellerModule(new User("Pedro", "123", true));


        Product p1 = new Product("Apple", "01", new Brand("AI", Type.FOOD),Type.FOOD,5.0,2);

        stock.createStockProduct(p1);

        Client client = new Client("Pedro2");

        module.newModule(client);
        module.addProduct(p1);
        module.addProduct(p1);
        module.addProduct(p1);
        module.addProduct(p1);
        module.setPaymentMethod(PaymentMethod.MONEY);
        module.processModule();

    }

}
