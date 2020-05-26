package com.jmendoza.swa.hexagonal.customer.domain.services;

import com.jmendoza.swa.hexagonal.customer.common.constants.CustomerConstanst;
import com.jmendoza.swa.hexagonal.customer.common.customannotations.UseCase;
import com.jmendoza.swa.hexagonal.customer.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.CreateCustomerUseCase;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.CreateCustomerPort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.PasswordEncodePort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.ExistsCustomerPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@UseCase
public class CreateCustomerService implements CreateCustomerUseCase {

    private CreateCustomerPort createCustomerPort;
    private PasswordEncodePort passwordEncodePort;
    private ExistsCustomerPort existsCustomerPort;

    @Override
    public void createCustomer(Customer customer) throws GlobalException {

        if (existsCustomerPort.existsByEmail(customer.getEmail()))
            throw new GlobalException(CustomerConstanst.THIS_EMAIL_IS_ALREADY_REGISTERED);

        customer.setPassword(passwordEncodePort.passwordEncoder(customer.getPassword()));
        createCustomerPort.createCustomer(customer);
    }
}
