package com.pedroftw.Simple_PDV.controllers;

import com.pedroftw.Simple_PDV.infrastructure.entity.Product;
import com.pedroftw.Simple_PDV.infrastructure.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Product> saveProduct (@RequestBody  Product product){
        return ResponseEntity.ok().body(productService.saveProduct(product));
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteProduct (@PathVariable  String code){
        productService.deleteProduct(code);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{code}")
    public ResponseEntity<Product> getProduct(@PathVariable String code){
        return ResponseEntity.ok(productService.findProductByCode(code));
    }

    @PatchMapping("/{code}")
    public ResponseEntity<Product> updateProduct (@PathVariable String code, @RequestBody Product product){
        Product updatedProduct = productService.updateProduct(code, product);
        return ResponseEntity.ok(updatedProduct);
    }
}
