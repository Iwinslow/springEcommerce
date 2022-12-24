package com.ecommerce.coderhouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.coderhouse.model.Product;
import com.ecommerce.coderhouse.repositories.ProductRepository;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductById(Long idProduct){
        return productRepository.findById(idProduct);
    }

    public Product createProduct(Product product){
        return productRepository.save(product);
    }
}
