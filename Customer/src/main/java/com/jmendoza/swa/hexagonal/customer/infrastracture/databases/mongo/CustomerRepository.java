package com.jmendoza.swa.hexagonal.customer.infrastracture.databases.mongo;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

    boolean existsByEmail(String email);

    Optional<Customer> findByEmail(String email);
}
