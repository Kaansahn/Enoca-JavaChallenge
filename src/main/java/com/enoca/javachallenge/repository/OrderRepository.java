package com.enoca.javachallenge.repository;

import com.enoca.javachallenge.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findAllOrdersByCustomerId(Long customerId);
}
