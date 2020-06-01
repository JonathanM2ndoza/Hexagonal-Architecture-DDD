package com.jmendoza.swa.hexagonal.order.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Product {
    private String id;
    private Double price;
}