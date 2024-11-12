package com.enoca.javachallenge.controller;

import com.enoca.javachallenge.model.Customer;
import com.enoca.javachallenge.service.CustomerService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping
    public String addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
}
