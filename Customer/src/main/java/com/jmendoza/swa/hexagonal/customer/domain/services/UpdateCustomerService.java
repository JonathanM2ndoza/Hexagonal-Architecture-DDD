package com.jmendoza.swa.hexagonal.customer.domain.services;

import com.jmendoza.swa.hexagonal.customer.common.constants.CustomerConstanst;
import com.jmendoza.swa.hexagonal.customer.common.customannotations.UseCase;
import com.jmendoza.swa.hexagonal.customer.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.UpdateCustomerUseCase;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.GetCustomerIdPort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.PasswordEncodePort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.UpdateCustomerPort;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.Conditions;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@UseCase
public class UpdateCustomerService implements UpdateCustomerUseCase {

    private GetCustomerIdPort getCustomerIdPort;
    private UpdateCustomerPort updateCustomerPort;
    private PasswordEncodePort passwordEncodePort;

    private ModelMapper modelMapper;

    @Override
    public void updateCustomer(String id, Customer customer) throws ResourceNotFoundException {
        Customer customer1 = getCustomerIdPort.getCustomerById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CustomerConstanst.CUSTOMER_NOT_FOUND + id));

        if (!StringUtils.isBlank(customer.getPassword()))
            customer.setPassword(passwordEncodePort.passwordEncoder(customer.getPassword()));

        customer.setId(id);
        modelMapper.getConfiguration().setPropertyCondition(Conditions.isNotNull());
        modelMapper.map(customer, customer1);
        updateCustomerPort.updateCustomer(customer1);
    }
}