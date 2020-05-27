package com.jmendoza.swa.hexagonal.customer.domain.ports.outbound;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;

import java.util.Optional;

public interface GetCustomerIdPort {
    Optional<Customer> getCustomerById(String id);
}
