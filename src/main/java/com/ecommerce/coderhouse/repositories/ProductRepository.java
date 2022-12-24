package com.ecommerce.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.coderhouse.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
}
