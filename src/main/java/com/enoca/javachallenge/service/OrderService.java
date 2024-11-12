package com.enoca.javachallenge.service;

import com.enoca.javachallenge.model.Order;

import java.util.List;

public class OrderService implements IOrderService{
    @Override
    public String placeOrder(Order order) {
        return null;
    }

    @Override
    public Order getOrderForCode(Long orderId) {
        return null;
    }

    @Override
    public List<Order> getAllOrdersForCustomer(Long customerId) {
        return null;
    }
}
