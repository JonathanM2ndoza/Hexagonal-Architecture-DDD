package com.jmendoza.swa.hexagonal.customer.domain.ports.outbound;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;

import java.util.Optional;

public interface GetCustomerEmailPort {
    Optional<Customer> getCustomerByEmail(String email);
}
