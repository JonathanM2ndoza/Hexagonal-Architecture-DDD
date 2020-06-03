package com.jmendoza.swa.hexagonal.order.domain.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OrderProduct {
    private String orderProductId;
    private int quantity;
    private String productId;
    private Double productPrice;

    Double getAmount() {
        return productPrice.doubleValue() * this.getQuantity();
    }
}
