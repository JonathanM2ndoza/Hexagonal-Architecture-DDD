package com.jmendoza.swa.hexagonal.order.application.rest;

import com.jmendoza.swa.hexagonal.order.application.rest.response.CreateOrderResponse;
import com.jmendoza.swa.hexagonal.order.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.order.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.order.domain.model.Order;
import com.jmendoza.swa.hexagonal.order.domain.ports.inbound.CreateOrderUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createProduct(@Valid @RequestBody Order order) throws ParameterNotFoundException, GlobalException {
        createOrderUseCase.createOrder(order);
        return ResponseEntity.ok().body(CreateOrderResponse.builder().orderId(order.getOrderId()).build());
    }

}
