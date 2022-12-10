package com.ecommerce.coderhouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_cartitem")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cart_id", nullable = false)
    private Product cartId;

    @OneToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product productId;

    @Column(nullable = false)
    private int quantity;
    
}
