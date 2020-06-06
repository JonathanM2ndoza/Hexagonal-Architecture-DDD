package com.jmendoza.swa.hexagonal.domain.services;

import com.jmendoza.swa.hexagonal.common.constants.OrderConstanst;
import com.jmendoza.swa.hexagonal.common.customannotations.UseCase;
import com.jmendoza.swa.hexagonal.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.domain.model.Order;
import com.jmendoza.swa.hexagonal.domain.ports.inbound.CreateOrderUseCase;
import com.jmendoza.swa.hexagonal.domain.ports.outbound.CreateOrderPort;
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
        if (order.getCreatedAt() == null)
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