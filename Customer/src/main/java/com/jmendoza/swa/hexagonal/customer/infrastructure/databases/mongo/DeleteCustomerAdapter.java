package com.jmendoza.swa.hexagonal.customer.infrastructure.databases.mongo;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.DeleteCustomerPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerAdapter implements DeleteCustomerPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void deleteCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}
