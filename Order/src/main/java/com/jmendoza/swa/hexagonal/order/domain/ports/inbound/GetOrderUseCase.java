package com.jmendoza.swa.hexagonal.order.domain.ports.inbound;

import com.jmendoza.swa.hexagonal.order.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.order.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.order.domain.model.Order;

public interface GetOrderUseCase {
    Order getOrder(String orderId) throws ResourceNotFoundException, GlobalException;
}
