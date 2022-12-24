package com.ecommerce.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.coderhouse.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{
    
}
