package com.jmendoza.swa.hexagonal.product.domain.ports.outbound;

import com.jmendoza.swa.hexagonal.product.domain.model.Product;

import java.util.Optional;

public interface GetProductIdPort {
    Optional<Product> getProductById(String id);
}
