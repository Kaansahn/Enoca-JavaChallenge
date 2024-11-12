package com.enoca.javachallenge.service;

import com.enoca.javachallenge.model.Customer;
import com.enoca.javachallenge.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
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
