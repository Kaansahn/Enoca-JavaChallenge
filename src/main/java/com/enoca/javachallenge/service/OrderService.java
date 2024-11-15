package com.enoca.javachallenge.service;

import com.enoca.javachallenge.model.*;
import com.enoca.javachallenge.repository.OrderRepository;
import com.enoca.javachallenge.repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService implements IOrderService{
    private final OrderRepository orderRepository;
    private final CartService cartService;
    private final ProductService productService;
    private final ProductRepository productRepository;

    public OrderService(OrderRepository orderRepository, CartService cartService, ProductService productService, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.cartService = cartService;
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @Transactional
    public Order placeOrder(Long customerId) {
        Cart cart = cartService.getCart(customerId);

        if (cart == null || cart.getCartItems().isEmpty()) {
            throw new RuntimeException("You are unable to place an order because the cart is empty or does not exist!");
        }

        Order order = new Order();
        order.setCustomer(cart.getCustomer());
        order.setTotalPrice(cart.getTotalPrice());
        order.setOrderDate(LocalDateTime.now());

        List<OrderItem> orderItems = cart.getCartItems().stream().map(cartItem -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setProduct(cartItem.getProduct());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(cartItem.getProduct().getPrice());
            productService.updateStock(cartItem.getProduct().getId(), cartItem.getQuantity());

            return orderItem;
        }).collect(Collectors.toList());

        order.setOrderItems(orderItems);
        orderRepository.save(order);

        cartService.emptyCart(cart.getId());

        return order;
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
