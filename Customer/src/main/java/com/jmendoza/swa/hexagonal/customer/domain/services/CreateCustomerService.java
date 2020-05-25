package com.jmendoza.swa.hexagonal.customer.domain.services;

import com.jmendoza.swa.hexagonal.customer.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.CreateCustomerUseCase;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.CreateCustomerPort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.EncryptPasswordPort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.ExistsCustomerPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCustomerService implements CreateCustomerUseCase {

    private CreateCustomerPort createCustomerPort;

    private EncryptPasswordPort encryptPasswordPort;

    private ExistsCustomerPort existsCustomerPort;

    @Override
    public void createCustomer(Customer customer) throws GlobalException {

        if (existsCustomerPort.existsByEmail(customer.getEmail()))
            throw new GlobalException("This email is already registered.");

        customer.setPassword(encryptPasswordPort.passwordEncoder(customer.getPassword()));
        createCustomerPort.createCustomer(customer);
    }
}
