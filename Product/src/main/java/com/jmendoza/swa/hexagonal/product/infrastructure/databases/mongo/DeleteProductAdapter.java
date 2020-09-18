package com.jmendoza.swa.hexagonal.product.infrastructure.databases.mongo;

import com.jmendoza.swa.hexagonal.product.domain.model.Product;
import com.jmendoza.swa.hexagonal.product.domain.ports.outbound.DeleteProductPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteProductAdapter implements DeleteProductPort {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }
}
