package com.jmendoza.swa.hexagonal.order.domain.ports.inbound;

import com.jmendoza.swa.hexagonal.order.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.order.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.order.domain.model.Order;

public interface CreateOrderUseCase {
    void createOrder(Order order) throws ParameterNotFoundException, GlobalException;
}