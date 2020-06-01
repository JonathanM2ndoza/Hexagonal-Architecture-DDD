package com.jmendoza.swa.hexagonal.order.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderProduct {
    private String id;
    private int quantity;
    private Product product;

    Double getAmount() {
        return product.getPrice().doubleValue() * this.getQuantity();
    }
}
