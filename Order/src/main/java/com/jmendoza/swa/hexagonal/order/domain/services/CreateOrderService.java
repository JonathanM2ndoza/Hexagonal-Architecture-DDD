package com.jmendoza.swa.hexagonal.order.domain.services;

import com.jmendoza.swa.hexagonal.order.common.constants.OrderConstanst;
import com.jmendoza.swa.hexagonal.order.common.customannotations.UseCase;
import com.jmendoza.swa.hexagonal.order.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.order.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.order.domain.model.Order;
import com.jmendoza.swa.hexagonal.order.domain.ports.inbound.CreateOrderUseCase;
import com.jmendoza.swa.hexagonal.order.domain.ports.outbound.CreateOrderPort;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.StringUtils;

@AllArgsConstructor
@UseCase
public class CreateOrderService implements CreateOrderUseCase {

    private CreateOrderPort createOrderPort;

    @Override
    public void createOrder(Order order) throws ParameterNotFoundException, GlobalException {

        if (StringUtils.isBlank(order.getCustomerId()))
            getMessageParameterNotFoundException("customerId");
        if (StringUtils.isBlank(order.getCreatedAt()))
            getMessageParameterNotFoundException("createdAt");
        if (order.getOrderProductList() == null || order.getOrderProductList().isEmpty())
            getMessageParameterNotFoundException("orderProductList");

        //TODO: pending validate orderProductList

        createOrderPort.createOrder(order);
    }

    private void getMessageParameterNotFoundException(String parameter) throws ParameterNotFoundException {
        throw new ParameterNotFoundException(OrderConstanst.REQUIRED_PARAMETER + "\"" + parameter + "\"" + OrderConstanst.IS_NOT_PRESENT);
    }
}