package com.enoca.javachallenge.service;

import com.enoca.javachallenge.model.Cart;
import com.enoca.javachallenge.model.Product;

public interface ICartService {
    Cart getCart(Long customerId);
    Cart updateCart(Cart cart);
    String emptyCart(Long cartId);
    String addProductToCart(Long productId, Long cartId, int quantity);
    String removeProductFromCart(Long cartId, Long productId);
}
