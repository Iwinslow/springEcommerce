package com.ecommerce.coderhouse.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.coderhouse.model.Cart;
import com.ecommerce.coderhouse.repositories.CartRepository;

@Service
public class CartService {
    
    @Autowired
    CartRepository cartRepository;

    public Optional<Cart> getCartById(Long idCart){
        return cartRepository.findById(idCart);
    }

    public Cart createCart(Cart cart){
        return cartRepository.save(cart);
    }
    
    public Cart updateCart(Cart cart){
        return cartRepository.save(cart);
    }

    public void deleteCart(Long idCart) throws Exception {
        try {
            cartRepository.deleteById(idCart);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
