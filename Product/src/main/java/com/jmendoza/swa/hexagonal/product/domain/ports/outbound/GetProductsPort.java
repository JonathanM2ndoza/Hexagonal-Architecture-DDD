package com.jmendoza.swa.hexagonal.product.domain.ports.outbound;

import com.jmendoza.swa.hexagonal.product.domain.model.Product;

import java.util.List;

public interface GetProductsPort {
    List<Product> getProducts();
}
