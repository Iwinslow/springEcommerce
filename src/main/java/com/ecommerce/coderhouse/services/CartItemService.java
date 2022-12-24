package com.ecommerce.coderhouse.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.coderhouse.model.CartItem;
import com.ecommerce.coderhouse.repositories.CartItemRepository;

@Service
public class CartItemService {

    @Autowired
    CartItemRepository cartItemRepository;

    public Optional<CartItem> getCartItemById(Long idCartItem){
        return cartItemRepository.findById(idCartItem);
    }

    public CartItem createCartItem(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }
    
    public CartItem updateCartItem(CartItem cartItem){
        return cartItemRepository.save(cartItem);
    }

    public void deleteCartItem(Long idCartItem) throws Exception {
        try {
            cartItemRepository.deleteById(idCartItem);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
