package com.jmendoza.swa.hexagonal.customer.application.rest.response;

import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseMapper {

    @Autowired
    ModelMapper modelMapper;

    public CustomerLoginResponse convertCustomerToCustomerLoginResponse(Customer customer) {
        return modelMapper.map(customer, CustomerLoginResponse.class);
    }
}
