package com.jmendoza.swa.hexagonal.product.infrastracture.databases.mongo;

import com.jmendoza.swa.hexagonal.product.domain.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
