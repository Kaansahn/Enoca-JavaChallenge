package com.enoca.javachallenge.repository;

import com.enoca.javachallenge.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Customer, Long> {
}
