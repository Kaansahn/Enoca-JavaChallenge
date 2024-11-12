package com.enoca.javachallenge.service;

import com.enoca.javachallenge.model.Product;

public interface IProductService {
    Product getProduct(Long productId);
    String createProduct(Product product);
    Product updateProduct(Product product, Long productId);
    String deleteProduct(Long productId);
}
