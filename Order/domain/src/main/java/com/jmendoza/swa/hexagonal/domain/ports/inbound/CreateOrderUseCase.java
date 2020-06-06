package com.jmendoza.swa.hexagonal.domain.ports.inbound;

import com.jmendoza.swa.hexagonal.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.domain.model.Order;

public interface CreateOrderUseCase {
    void createOrder(Order order) throws ParameterNotFoundException, GlobalException;
}