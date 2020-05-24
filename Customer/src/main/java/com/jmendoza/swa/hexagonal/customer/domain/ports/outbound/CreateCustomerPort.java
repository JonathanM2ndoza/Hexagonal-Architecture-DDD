package com.jmendoza.swa.hexagonal.customer.domain.ports.outbound;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;

public interface CreateCustomerPort {
    void createCustomer(Customer customer);
}
