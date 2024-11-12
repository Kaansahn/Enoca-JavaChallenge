package com.enoca.javachallenge.service;

import com.enoca.javachallenge.model.Cart;
import com.enoca.javachallenge.model.CartItem;
import com.enoca.javachallenge.model.Product;
import com.enoca.javachallenge.repository.CartRepository;
import com.enoca.javachallenge.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CartService implements ICartService{
    private final CartRepository cartRepository;
    private final ProductService productService;

    public CartService(CartRepository cartRepository, ProductService productService) {
        this.cartRepository = cartRepository;
        this.productService = productService;
    }

    @Override
    public Cart getCart(Long customerId) {
        return cartRepository.findByCustomerId(customerId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found"));
    }

    @Override
    public Cart updateCart(Cart cart, Long cartId) {
        updateTotalPrice(cart);
        return cartRepository.save(cart);
    }

    @Override
    public String emptyCart(Long cartId) {
        Cart cart = getCart(cartId);
        cart.getCartItems().clear();
        updateTotalPrice(cart);
        cartRepository.save(cart);
        return "Cart is empty";
    }

    @Override
    public String addProductToCart(Long productId, Long cartId, int quantity) {
        Cart cart = cartRepository.findById(cartId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cart not found"));

        if(productService.isProductInStock(productId, quantity)){
            CartItem cartItem = new CartItem();
            cartItem.setProduct(productService.getProduct(productId));
            cartItem.setQuantity(quantity);
            cart.getCartItems().add(cartItem);
            updateTotalPrice(cart);
            cartRepository.save(cart);
            return "Product successfully added to the cart";
        }else{
            throw new RuntimeException("There is no enough stock for the product");
        }
    }

    @Override
    public String removeProductToCart(Long cartId, Long productId) {
        Cart cart = getCart(cartId);
        cart.getCartItems().removeIf(item -> item.getProduct().getId().equals(productId));
        updateTotalPrice(cart);
        cartRepository.save(cart);
        return "Product successfully removed from the cart";
    }

    private void updateTotalPrice(Cart cart) {
        double totalPrice = cart.getCartItems().stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();
        cart.setTotalPrice(totalPrice);
    }
}
