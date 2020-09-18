package com.jmendoza.swa.hexagonal.customer.infrastructure.databases.mongo;

import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.ExistsCustomerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistsCustomerAdapter implements ExistsCustomerPort {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }
}
