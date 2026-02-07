package com.pedroftw.Simple_PDV.infrastructure.repository;

import com.pedroftw.Simple_PDV.infrastructure.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findByCode(String code);
    void deleteByCode(String code);
}
