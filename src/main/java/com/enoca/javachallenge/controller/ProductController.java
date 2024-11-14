package com.enoca.javachallenge.controller;

import com.enoca.javachallenge.model.Product;
import com.enoca.javachallenge.service.IProductService;
import com.enoca.javachallenge.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public String createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

    @GetMapping("/{productId}")
    public Product getProduct(@PathVariable Long productId){
        return productService.getProduct(productId);
    }

    @PutMapping("/{productId}")
    public Product updateProduct(@RequestBody Product updatedProduct, @PathVariable Long productId){
        return productService.updateProduct(updatedProduct ,productId);
    }

    @DeleteMapping("/{productId}")
    public void deleteProduct(@PathVariable Long productId){
        productService.deleteProduct(productId);
    }
}
