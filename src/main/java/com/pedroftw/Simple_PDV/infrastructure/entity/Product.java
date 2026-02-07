package com.pedroftw.Simple_PDV.infrastructure.entity;

import com.pedroftw.Simple_PDV.modules.Type;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "products")

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    private String name;
    private String description;

    @Enumerated(EnumType.STRING)
    private Type type;

    private Double price;
    private Integer stock;



}
