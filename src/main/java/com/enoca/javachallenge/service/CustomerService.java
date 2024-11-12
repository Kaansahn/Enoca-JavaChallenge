package com.enoca.javachallenge.service;

import com.enoca.javachallenge.model.Customer;
import com.enoca.javachallenge.repository.CustomerRepository;

public class CustomerService implements ICustomerService{
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public String addCustomer(Customer customer) {
        customerRepository.save(customer);
        return "Customer successfully added!";
    }
}
