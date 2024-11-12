package com.enoca.javachallenge.service;

import com.enoca.javachallenge.model.Cart;
import com.enoca.javachallenge.model.Product;

public interface ICartService {
    Cart getCart(Long cartId);
    Cart updateCart(Cart cart, Long cartId);
    String emptyCart(Long cartId);
    String addProductToCart(Product product, Long cartId);
    String removeProductToCart(Product product, Long cartId);
}
