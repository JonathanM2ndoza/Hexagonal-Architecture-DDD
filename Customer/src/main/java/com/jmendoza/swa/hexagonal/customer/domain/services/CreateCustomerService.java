package com.jmendoza.swa.hexagonal.customer.domain.services;

import com.jmendoza.swa.hexagonal.customer.common.constants.CustomerConstanst;
import com.jmendoza.swa.hexagonal.customer.common.customannotations.UseCase;
import com.jmendoza.swa.hexagonal.customer.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.customer.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.CreateCustomerUseCase;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.CreateCustomerPort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.ExistsCustomerPort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.PasswordEncodePort;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor
@UseCase
public class CreateCustomerService implements CreateCustomerUseCase {

    private CreateCustomerPort createCustomerPort;
    private PasswordEncodePort passwordEncodePort;
    private ExistsCustomerPort existsCustomerPort;

    @Override
    public void createCustomer(Customer customer) throws GlobalException, ParameterNotFoundException {

        // Field validations to save
        if (StringUtils.isBlank(customer.getFirstName()))
            getMessageParameterNotFoundException("firstName");

        if (StringUtils.isBlank(customer.getLastName()))
            getMessageParameterNotFoundException("lastName");

        if (StringUtils.isBlank(customer.getEmail()))
            getMessageParameterNotFoundException("email");

        if (StringUtils.isBlank(customer.getPassword()))
            getMessageParameterNotFoundException("password");

        if (StringUtils.isBlank(customer.getCreatedAt()))
            getMessageParameterNotFoundException("createdAt");

        // Validate that the email does not exist
        if (existsCustomerPort.existsByEmail(customer.getEmail()))
            throw new GlobalException(CustomerConstanst.THIS_EMAIL_IS_ALREADY_REGISTERED);

        // Encrypt password
        customer.setPassword(passwordEncodePort.passwordEncoder(customer.getPassword()));

        // Save Customer
        createCustomerPort.createCustomer(customer);
    }

    private void getMessageParameterNotFoundException(String parameter) throws ParameterNotFoundException {
        throw new ParameterNotFoundException(CustomerConstanst.REQUIRED_PARAMETER + "\"" + parameter + "\"" + CustomerConstanst.IS_NOT_PRESENT);
    }
}
