package com.enoca.javachallenge.service;


import com.enoca.javachallenge.model.Customer;
import com.enoca.javachallenge.model.Order;
import com.enoca.javachallenge.model.Product;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long customerId);
    Order getOrderForCode(Long orderId);
    List<Order> getAllOrdersForCustomer(Long customerId);
}
