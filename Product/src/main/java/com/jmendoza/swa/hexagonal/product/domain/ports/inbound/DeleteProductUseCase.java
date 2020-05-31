package com.jmendoza.swa.hexagonal.product.domain.ports.inbound;

import com.jmendoza.swa.hexagonal.product.common.exception.ResourceNotFoundException;

public interface DeleteProductUseCase {
    void deleteProduct(String id) throws ResourceNotFoundException;
}
