package com.enoca.javachallenge.controller;

import com.enoca.javachallenge.model.Customer;
import com.enoca.javachallenge.service.CustomerService;
import com.enoca.javachallenge.service.ICustomerService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final ICustomerService customerService;

    public CustomerController(ICustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }
}
