package com.jmendoza.swa.hexagonal.order.application.rest;

import com.jmendoza.swa.hexagonal.order.application.rest.response.CreateOrderResponse;
import com.jmendoza.swa.hexagonal.order.common.exception.GlobalException;
import com.jmendoza.swa.hexagonal.order.common.exception.ParameterNotFoundException;
import com.jmendoza.swa.hexagonal.order.common.exception.ResourceNotFoundException;
import com.jmendoza.swa.hexagonal.order.domain.model.Order;
import com.jmendoza.swa.hexagonal.order.domain.ports.inbound.CreateOrderUseCase;
import com.jmendoza.swa.hexagonal.order.domain.ports.inbound.GetOrderUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/orders")
@AllArgsConstructor
public class OrderController {

    private final CreateOrderUseCase createOrderUseCase;
    private final GetOrderUseCase getOrderUseCase;

    @PostMapping
    public ResponseEntity<CreateOrderResponse> createOrder(@Valid @RequestBody Order order) throws ParameterNotFoundException, GlobalException {
        createOrderUseCase.createOrder(order);
        return ResponseEntity.ok().body(CreateOrderResponse.builder().orderId(order.getOrderId()).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable(value = "id") String id) throws ResourceNotFoundException, GlobalException {
        return ResponseEntity.ok().body(getOrderUseCase.getOrder(id));
    }
}
