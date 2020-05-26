package com.jmendoza.swa.hexagonal.customer.infrastracture.databases.mongo;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.CreateCustomerPort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.ExistsCustomerPort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.GetCustomerEmailPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerRepositoryAdapter implements CreateCustomerPort, ExistsCustomerPort, GetCustomerEmailPort {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }

    @Override
    public Optional<Customer> getCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
