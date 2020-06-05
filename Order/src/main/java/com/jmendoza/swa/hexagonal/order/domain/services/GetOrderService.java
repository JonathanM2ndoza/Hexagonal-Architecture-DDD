package com.jmendoza.swa.hexagonal.order.domain.services;

import com.jmendoza.swa.hexagonal.order.common.constants.OrderConstanst;
import com.jmendoza.swa.hexagonal.order.common.customannotations.UseCase;
import com.jmendoza.swa.hexagonal.order.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.order.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.order.domain.model.Order;
import com.jmendoza.swa.hexagonal.order.domain.ports.inbound.GetOrderUseCase;
import com.jmendoza.swa.hexagonal.order.domain.ports.outbound.GetOrderPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@UseCase
public class GetOrderService implements GetOrderUseCase {

    private GetOrderPort getOrderPort;

    @Override
    public Order getOrder(String orderId) throws ResourceNotFoundException, GlobalException {
        final Order order = getOrderPort.getOrder(orderId);
        if (order == null)
            throw new ResourceNotFoundException(OrderConstanst.ORDER_NOT_FOUND + orderId);

        return order;
    }
}
