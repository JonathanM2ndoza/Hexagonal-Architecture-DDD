package com.jmendoza.swa.hexagonal.customer.domain.ports.outbound;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;

public interface UpdateCustomerPort {
    void updateCustomer(Customer customer);
}
