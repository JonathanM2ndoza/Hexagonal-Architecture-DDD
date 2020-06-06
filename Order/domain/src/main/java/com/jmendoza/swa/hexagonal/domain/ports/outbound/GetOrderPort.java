package com.jmendoza.swa.hexagonal.domain.ports.outbound;

import com.jmendoza.swa.hexagonal.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.domain.model.Order;

public interface GetOrderPort {
    Order getOrder(String orderId) throws GlobalException;
}
