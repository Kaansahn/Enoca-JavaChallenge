package com.enoca.javachallenge.service;

import com.enoca.javachallenge.model.Cart;
import com.enoca.javachallenge.model.Product;

public class CartService implements ICartService{
    @Override
    public Cart getCart(Long cartId) {
        return null;
    }

    @Override
    public Cart updateCart(Cart cart, Long cartId) {
        return null;
    }

    @Override
    public String emptyCart(Long cartId) {
        return null;
    }

    @Override
    public String addProductToCart(Product product, Long cartId) {
        return null;
    }

    @Override
    public String removeProductToCart(Product product, Long cartId) {
        return null;
    }
}
