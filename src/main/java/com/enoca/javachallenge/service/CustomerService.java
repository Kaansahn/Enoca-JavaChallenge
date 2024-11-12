package com.enoca.javachallenge.service;

import com.enoca.javachallenge.model.Cart;
import com.enoca.javachallenge.model.Customer;
import com.enoca.javachallenge.repository.CartRepository;
import com.enoca.javachallenge.repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService implements ICustomerService{
    private final CustomerRepository customerRepository;
    private final CartRepository cartRepository;

    public CustomerService(CustomerRepository customerRepository, CartRepository cartRepository) {
        this.customerRepository = customerRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public String addCustomer(Customer customer) {
        Customer savedCustomer = customerRepository.save(customer);

        Cart cart = new Cart();
        cart.setCustomer(savedCustomer);
        cartRepository.save(cart);

        return "Customer successfully added!";
    }
}
