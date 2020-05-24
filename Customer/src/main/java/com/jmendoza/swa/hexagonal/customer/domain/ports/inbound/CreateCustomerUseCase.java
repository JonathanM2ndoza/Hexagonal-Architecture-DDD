package com.jmendoza.swa.hexagonal.customer.domain.ports.inbound;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.infrastracture.adapters.configuration.exception.GlobalException;

public interface CreateCustomerUseCase {
    void createCustomer(Customer customer) throws GlobalException;
}