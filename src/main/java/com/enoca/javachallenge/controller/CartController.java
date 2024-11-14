package com.enoca.javachallenge.controller;

import com.enoca.javachallenge.model.Cart;
import com.enoca.javachallenge.service.ICartService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/carts")
public class CartController {
    private final ICartService cartService;

    public CartController(ICartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{customerId}")
    public Cart getCart(@PathVariable Long customerId){
        return cartService.getCart(customerId);
    }

    @PutMapping("/{cartId}")
    public Cart updateCart(@RequestBody Cart cart) {
        return cartService.updateCart(cart);
    }

    @DeleteMapping("/{cartId}/empty")
    public String emptyCart(@PathVariable Long cartId) {
        return cartService.emptyCart(cartId);
    }

    @PostMapping("/{cartId}/addproduct/{productId}")
    public String addProductToCart(@PathVariable Long productId, @PathVariable Long cartId, @RequestParam int quantity) {
        return cartService.addProductToCart(productId, cartId, quantity);
    }

    @DeleteMapping("/{cartId}/removeproduct/{productId}")
    public String removeProductFromCart(@PathVariable Long cartId, @PathVariable Long productId) {
        return cartService.removeProductFromCart(cartId, productId);
    }
}
