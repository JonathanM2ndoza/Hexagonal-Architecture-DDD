package com.jmendoza.swa.hexagonal.customer.infrastracture.databases.mongo;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    @Autowired
    ModelMapper modelMapper;

    public com.jmendoza.swa.hexagonal.customer.infrastracture.databases.mongo.Customer convertCustomerToCustomerMongo(Customer customer) {
        return modelMapper.map(customer, com.jmendoza.swa.hexagonal.customer.infrastracture.databases.mongo.Customer.class);
    }
}
