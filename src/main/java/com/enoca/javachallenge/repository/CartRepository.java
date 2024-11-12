package com.enoca.javachallenge.repository;

import com.enoca.javachallenge.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Customer, Long> {
}
