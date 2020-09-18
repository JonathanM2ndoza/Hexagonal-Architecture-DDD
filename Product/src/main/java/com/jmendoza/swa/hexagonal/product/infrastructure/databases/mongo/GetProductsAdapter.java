package com.jmendoza.swa.hexagonal.product.infrastructure.databases.mongo;

import com.jmendoza.swa.hexagonal.product.domain.model.Product;
import com.jmendoza.swa.hexagonal.product.domain.ports.outbound.GetProductsPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetProductsAdapter implements GetProductsPort {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
