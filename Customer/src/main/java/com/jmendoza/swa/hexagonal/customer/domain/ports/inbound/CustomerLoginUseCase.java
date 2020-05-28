package com.jmendoza.swa.hexagonal.customer.domain.ports.inbound;

import com.jmendoza.swa.hexagonal.customer.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.customer.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.customer.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;

public interface CustomerLoginUseCase {
    Customer customerLogin(String email, String password) throws ResourceNotFoundException, GlobalException, ParameterNotFoundException;
}