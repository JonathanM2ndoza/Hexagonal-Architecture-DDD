package com.jmendoza.swa.hexagonal.customer.infrastracture.adapters.databases.mongo;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.CreateCustomerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerRepositoryAdapter implements CreateCustomerPort {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}