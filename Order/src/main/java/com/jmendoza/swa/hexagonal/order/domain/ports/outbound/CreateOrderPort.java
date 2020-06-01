package com.jmendoza.swa.hexagonal.order.domain.ports.outbound;

import com.jmendoza.swa.hexagonal.order.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.order.domain.model.Order;

public interface CreateOrderPort {
    void createOrder(Order order) throws GlobalException;
}
