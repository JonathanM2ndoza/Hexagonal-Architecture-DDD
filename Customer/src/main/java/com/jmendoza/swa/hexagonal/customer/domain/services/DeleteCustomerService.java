package com.jmendoza.swa.hexagonal.customer.domain.services;

import com.jmendoza.swa.hexagonal.customer.common.constants.CustomerConstanst;
import com.jmendoza.swa.hexagonal.customer.common.customannotations.UseCase;
import com.jmendoza.swa.hexagonal.customer.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.customer.domain.model.Customer;
import com.jmendoza.swa.hexagonal.customer.domain.ports.inbound.DeleteCustomerUseCase;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.DeleteCustomerPort;
import com.jmendoza.swa.hexagonal.customer.domain.ports.outbound.GetCustomerIdPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@UseCase
public class DeleteCustomerService implements DeleteCustomerUseCase {

    private GetCustomerIdPort getCustomerIdPort;
    private DeleteCustomerPort deleteCustomerPort;

    @Override
    public void deleteCustomer(String id) throws ResourceNotFoundException {
        Customer customer = getCustomerIdPort.getCustomerById(id)
                .orElseThrow(() -> new ResourceNotFoundException(CustomerConstanst.CUSTOMER_NOT_FOUND + id));
        deleteCustomerPort.deleteCustomer(customer);

    }
}
