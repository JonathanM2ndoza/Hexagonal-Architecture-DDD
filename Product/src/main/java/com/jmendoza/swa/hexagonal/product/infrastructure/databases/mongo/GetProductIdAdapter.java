package com.jmendoza.swa.hexagonal.product.infrastructure.databases.mongo;

import com.jmendoza.swa.hexagonal.product.domain.model.Product;
import com.jmendoza.swa.hexagonal.product.domain.ports.outbound.GetProductIdPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetProductIdAdapter implements GetProductIdPort {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }
}
