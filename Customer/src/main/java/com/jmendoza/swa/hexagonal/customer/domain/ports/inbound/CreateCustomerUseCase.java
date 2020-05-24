package com.jmendoza.swa.hexagonal.customer.domain.ports.inbound;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;

public interface CreateCustomerUseCase {
    void createCustomer(Customer customer);
}