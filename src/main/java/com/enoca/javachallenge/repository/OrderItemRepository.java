package com.enoca.javachallenge.repository;

import com.enoca.javachallenge.model.Customer;
import com.enoca.javachallenge.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<Customer, Long> {
}
