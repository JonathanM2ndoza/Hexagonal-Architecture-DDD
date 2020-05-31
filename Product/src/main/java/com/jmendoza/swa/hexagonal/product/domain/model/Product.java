package com.jmendoza.swa.hexagonal.product.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private String id;
    private String productName;
    private String productDescription;
    private Double price;
    private String createdAt;
    private String serialNumber;
}
