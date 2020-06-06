package com.jmendoza.swa.hexagonal.domain.ports.inbound;

import com.jmendoza.swa.hexagonal.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.domain.model.Order;

public interface GetOrderUseCase {
    Order getOrder(String orderId) throws ResourceNotFoundException, GlobalException;
}
