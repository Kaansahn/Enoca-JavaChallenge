package com.enoca.javachallenge.repository;

import com.enoca.javachallenge.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
