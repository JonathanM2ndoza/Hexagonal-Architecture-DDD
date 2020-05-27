package com.jmendoza.swa.hexagonal.customer.domain.ports.inbound;

import com.jmendoza.swa.hexagonal.customer.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;

public interface UpdateCustomerUseCase {
    void updateCustomer(String id, Customer customer) throws ResourceNotFoundException;
}
