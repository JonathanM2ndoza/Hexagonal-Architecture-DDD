package com.jmendoza.swa.hexagonal.product.domain.ports.outbound;

import com.jmendoza.swa.hexagonal.product.domain.model.Product;

public interface DeleteProductPort {
    void deleteProduct(Product product);
}
