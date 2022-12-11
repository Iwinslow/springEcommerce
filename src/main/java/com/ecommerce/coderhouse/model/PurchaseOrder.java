package com.ecommerce.coderhouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="purchase_orders")
public class PurchaseOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_purch_order")
    private Long id;

    @Column(nullable = false, updatable = false)
    private String deliveryAddress;

    @Column(nullable = false, updatable = false)
    private String paymentMethod;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    public PurchaseOrder() {
    }

    public PurchaseOrder(String deliveryAddress, String paymentMethod, Cart cart) {
        this.deliveryAddress = deliveryAddress;
        this.paymentMethod = paymentMethod;
        this.cart = new Cart();
    }

    //getters & setters
    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }


    
    
}
