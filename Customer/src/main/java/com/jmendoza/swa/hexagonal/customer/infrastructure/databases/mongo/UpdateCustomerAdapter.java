package com.jmendoza.swa.hexagonal.customer.infrastructure.databases.mongo;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.UpdateCustomerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }
}
