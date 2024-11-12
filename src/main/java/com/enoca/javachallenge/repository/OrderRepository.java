package com.enoca.javachallenge.repository;

import com.enoca.javachallenge.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
