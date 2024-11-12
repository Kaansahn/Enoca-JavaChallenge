package com.enoca.javachallenge.service;

import com.enoca.javachallenge.model.Cart;
import com.enoca.javachallenge.model.Order;
import com.enoca.javachallenge.model.OrderItem;
import com.enoca.javachallenge.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService implements IOrderService{
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final ProductService productService;

    public OrderService(OrderRepository orderRepository, CartService cartService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.productService = productService;
    }

    @Override
    public String placeOrder(Long customerId) {
        Cart cart = cartService.getCart(customerId);

        if(cart.getCartItems().isEmpty()){
            throw new RuntimeException("You are unable to place an order because cart is empty!");
        }

        Order order = new Order();
        order.setCustomer(cart.getCustomer());
        order.setTotalPrice(cart.getTotalPrice());
        order.setOrderDate(LocalDateTime.now());

        List<OrderItem> orderItems = (List<OrderItem>) cart.getCartItems().stream().map(cartItem -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getProduct().getPrice());
            productService.updateStock(cartItem.getProduct().getId(), cartItem.getQuantity());
            return orderItem;
        }).toList();

        order.setOrderItems(orderItems);
        cartService.emptyCart(cart.getId());

        orderRepository.save(order);

        return "Order placed successfully";
    }

    @Override
    public Order getOrderForCode(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
    }

    @Override
    public List<Order> getAllOrdersForCustomer(Long customerId) {
        return orderRepository.findAllOrdersByCustomerId(customerId);
    }
}
