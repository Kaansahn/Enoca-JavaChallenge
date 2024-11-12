package com.enoca.javachallenge.controller;

import com.enoca.javachallenge.model.Order;
import com.enoca.javachallenge.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/placeorder/{customerId}")
    public String placeOrder(@PathVariable Long customerId) {
        return orderService.placeOrder(customerId);
    }

    @GetMapping("/{orderId}")
    public Order getOrderForCode(@PathVariable Long orderId) {
        return orderService.getOrderForCode(orderId);
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getAllOrdersForCustomer(@PathVariable Long customerId) {
        return getAllOrdersForCustomer(customerId);
    }
}