package com.jmendoza.swa.hexagonal.domain.services;

import com.jmendoza.swa.hexagonal.common.constants.OrderConstanst;
import com.jmendoza.swa.hexagonal.common.customannotations.UseCase;
import com.jmendoza.swa.hexagonal.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.domain.model.Order;
import com.jmendoza.swa.hexagonal.domain.ports.inbound.GetOrderUseCase;
import com.jmendoza.swa.hexagonal.domain.ports.outbound.GetOrderPort;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@UseCase
public class GetOrderService implements GetOrderUseCase {

    private GetOrderPort getOrderPort;

    @Override
    public Order getOrder(String orderId) throws ResourceNotFoundException, GlobalException {
        try {
            final Order order = getOrderPort.getOrder(orderId);
            if (order == null)
                throw new ResourceNotFoundException(OrderConstanst.ORDER_NOT_FOUND + orderId);

            return order;
        } catch (Exception e) {
            throw new GlobalException("getOrder: " + e.getMessage());
        }

    }
}
