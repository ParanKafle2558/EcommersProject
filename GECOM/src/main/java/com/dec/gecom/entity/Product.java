package com.dec.gecom.entity;


import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "e_product")
@Setter
@Getter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long product_id;

    @Column(name="product_name")
    private String productName;

    @Column(name="product_price")
    private Double price;

}
