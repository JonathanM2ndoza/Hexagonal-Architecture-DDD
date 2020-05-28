package com.jmendoza.swa.hexagonal.customer.domain.services;

import com.jmendoza.swa.hexagonal.customer.common.constants.CustomerConstanst;
import com.jmendoza.swa.hexagonal.customer.common.customannotations.UseCase;
import com.jmendoza.swa.hexagonal.customer.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.customer.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.customer.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.CustomerLoginUseCase;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.GetCustomerEmailPort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.PasswordMatchesPort;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

@AllArgsConstructor
@UseCase
public class CustomerLoginService implements CustomerLoginUseCase {

    private GetCustomerEmailPort getCustomerEmailPort;
    private PasswordMatchesPort passwordMatchesPort;

    @Override
    public Customer customerLogin(String email, String password) throws ResourceNotFoundException, GlobalException, ParameterNotFoundException {

        if (StringUtils.isBlank(email))
            getMessageParameterNotFoundException("email");
        if (StringUtils.isBlank(password))
            getMessageParameterNotFoundException("password");

        Optional<Customer> customerOptional;
        Customer customer = null;
        customerOptional = Optional.ofNullable(getCustomerEmailPort.getCustomerByEmail(email).orElseThrow(() -> new ResourceNotFoundException(CustomerConstanst.CUSTOMER_NOT_FOUND + email)));
        if (customerOptional.isPresent()) {
            customer = customerOptional.get();
            if (!passwordMatchesPort.passwordMatchesPort(password, customer.getPassword()))
                throw new GlobalException(CustomerConstanst.THE_PASSWORD_IS_INCORRECT);

            customer.setPassword(StringUtils.EMPTY);
        }
        return customer;
    }

    private void getMessageParameterNotFoundException(String parameter) throws ParameterNotFoundException {
        throw new ParameterNotFoundException(CustomerConstanst.REQUIRED_PARAMETER + "\"" + parameter + "\"" + CustomerConstanst.IS_NOT_PRESENT);
    }
}
