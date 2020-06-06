package com.jmendoza.swa.hexagonal.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class OrderProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    private int orderProductId;
    private int quantity;
    private String productId;
    private Double productPrice;

    Double getAmount() {
        return productPrice.doubleValue() * this.getQuantity();
    }
}
