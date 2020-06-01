package com.jmendoza.swa.hexagonal.product.domain.ports.inbound;

import com.jmendoza.swa.hexagonal.product.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.product.domain.model.Product;

public interface GetProductUseCase {

    Product getProduct(String id) throws ResourceNotFoundException;
}
