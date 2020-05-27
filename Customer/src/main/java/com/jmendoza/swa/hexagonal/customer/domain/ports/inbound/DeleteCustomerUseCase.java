package com.jmendoza.swa.hexagonal.customer.domain.ports.inbound;

import com.jmendoza.swa.hexagonal.customer.common.exception.ResourceNotFoundException;

public interface DeleteCustomerUseCase {
    void deleteCustomer(String id) throws ResourceNotFoundException;
}
