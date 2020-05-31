package com.jmendoza.swa.hexagonal.product.domain.ports.inbound;

import com.jmendoza.swa.hexagonal.product.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.product.domain.model.Product;

public interface CreateProductUseCase {
    void createProduct(Product product) throws ParameterNotFoundException;
}