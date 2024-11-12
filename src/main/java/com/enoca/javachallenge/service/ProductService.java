package com.enoca.javachallenge.service;

import com.enoca.javachallenge.model.Product;
import com.enoca.javachallenge.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product getProduct(Long productId) {
        List<Product> products = productRepository.findAll();

        Optional<Product> optionalProduct = products.stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst();

        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    @Override
    public String createProduct(Product product) {
        productRepository.save(product);
        return "Product successfully created!";
    }

    @Override
    public Product updateProduct(Product product, Long productId) {
        List<Product> products = productRepository.findAll();

        Optional<Product> optionalProduct = products.stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst();

        if(optionalProduct.isPresent()){
            Product existingProduct = optionalProduct.get();
            existingProduct.setName(product.getName());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setStock(product.getStock());

            Product savedProduct = productRepository.save(existingProduct);

            return savedProduct;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }

    @Override
    public String deleteProduct(Long productId) {
        List<Product> products = productRepository.findAll();

        Product product = products.stream()
                .filter(p -> p.getId().equals(productId))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));

        productRepository.delete(product);

        return "Product with product id: " + productId + " deleted successfully!";
    }

    public boolean isProductInStock(Long productId, int quantity){
        Product product = getProduct(productId);
        return product.getStock() >= quantity;
    }

    public void updateStock(Long productId, int quantity){
        Product product = getProduct(productId);
        product.setStock(product.getStock() - quantity);
        productRepository.save(product);
    }
}
