package com.pedroftw.Simple_PDV.infrastructure.services;

import com.pedroftw.Simple_PDV.infrastructure.entity.Product;
import com.pedroftw.Simple_PDV.infrastructure.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public Product saveProduct(Product product) {
        Product p = productRepository.findByCode(product.getCode());

        if(Objects.nonNull(p)) {
            throw new RuntimeException("Product already exists");
        } else{
            return productRepository.save(product);
        }
    }
    @Transactional
    public void deleteProduct(String code) {
        if(Objects.isNull(productRepository.findByCode(code))) {
            throw new RuntimeException("Product not found with code: " + code);
        }
        productRepository.deleteByCode(code);
    }

    public Product findProductByCode(String code) {
        Product product = productRepository.findByCode(code);
        if(Objects.isNull(product)) {
            throw new RuntimeException("Product not found");
        } else{
            return product;
        }
    }

    public Product updateProduct(String code,Product newProduct) {
        Product product = productRepository.findByCode(code);
        if(Objects.isNull(product)){
            throw new RuntimeException("Product not found");
        }
        if(newProduct.getName()!=null) product.setName(newProduct.getName());
        if(newProduct.getDescription()!=null) product.setDescription(newProduct.getDescription());
        if(newProduct.getPrice()!=null) product.setPrice(newProduct.getPrice());
        if(newProduct.getStock()!=null) product.setStock(newProduct.getStock());
        if(newProduct.getType()!=null) product.setType(newProduct.getType());
        return productRepository.save(product);
    }
}
