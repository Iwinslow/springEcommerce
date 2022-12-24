package com.ecommerce.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.coderhouse.model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    
}
