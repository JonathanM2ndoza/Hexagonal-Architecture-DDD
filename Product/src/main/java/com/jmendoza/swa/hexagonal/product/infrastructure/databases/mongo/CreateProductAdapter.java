package com.jmendoza.swa.hexagonal.product.infrastructure.databases.mongo;

import com.jmendoza.swa.hexagonal.product.domain.model.Product;
import com.jmendoza.swa.hexagonal.product.domain.ports.outbound.CreateProductPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProductAdapter implements CreateProductPort {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }
}
