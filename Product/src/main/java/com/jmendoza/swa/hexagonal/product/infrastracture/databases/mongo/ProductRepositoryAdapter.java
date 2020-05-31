package com.jmendoza.swa.hexagonal.product.infrastracture.databases.mongo;

import com.jmendoza.swa.hexagonal.product.domain.model.Product;
import com.jmendoza.swa.hexagonal.product.domain.ports.outbound.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductRepositoryAdapter implements CreateProductPort, GetProductIdPort, DeleteProductPort, ExistsProductPort, GetProductsPort {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void createProduct(Product product) {
        productRepository.save(product);
    }

    @Override
    public void deleteProduct(Product product) {
        productRepository.delete(product);
    }

    @Override
    public Optional<Product> getProductById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public boolean existsBySerialNumber(String serialNumber) {
        return productRepository.existsBySerialNumber(serialNumber);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }
}
