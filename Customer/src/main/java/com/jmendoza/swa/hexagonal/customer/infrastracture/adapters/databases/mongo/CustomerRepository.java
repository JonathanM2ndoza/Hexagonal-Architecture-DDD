package com.jmendoza.swa.hexagonal.customer.infrastracture.adapters.databases.mongo;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {
}
