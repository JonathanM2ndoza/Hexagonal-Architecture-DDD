package com.jmendoza.swa.hexagonal.product.domain.ports.inbound;

import com.jmendoza.swa.hexagonal.product.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.product.domain.model.Product;

import java.util.List;

public interface GetProductsUseCase {
    List<Product> getProducts() throws ResourceNotFoundException;
}
