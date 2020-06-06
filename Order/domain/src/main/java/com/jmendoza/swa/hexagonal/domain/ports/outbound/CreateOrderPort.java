package com.jmendoza.swa.hexagonal.domain.ports.outbound;

import com.jmendoza.swa.hexagonal.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.domain.model.Order;

public interface CreateOrderPort {
    void createOrder(Order order) throws GlobalException;
}
