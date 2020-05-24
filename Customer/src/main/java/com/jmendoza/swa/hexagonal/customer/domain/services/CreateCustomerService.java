package com.jmendoza.swa.hexagonal.customer.domain.services;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.CreateCustomerUseCase;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.CreateCustomerPort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.EncryptPasswordPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateCustomerService implements CreateCustomerUseCase {

    private CreateCustomerPort createCustomerPort;

    private EncryptPasswordPort encryptPasswordPort;

    @Override
    public void createCustomer(Customer customer) {
        customer.setPassword(encryptPasswordPort.passwordEncoder(customer.getPassword()));
        createCustomerPort.createCustomer(customer);
    }
}
