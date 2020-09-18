package com.jmendoza.swa.hexagonal.customer.infrastructure.databases.mongo;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.GetCustomerIdPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetCustomerIdAdapter implements GetCustomerIdPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }
}
