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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((deliveryAddress == null) ? 0 : deliveryAddress.hashCode());
        result = prime * result + ((paymentMethod == null) ? 0 : paymentMethod.hashCode());
        result = prime * result + ((cart == null) ? 0 : cart.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PurchaseOrder other = (PurchaseOrder) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (deliveryAddress == null) {
            if (other.deliveryAddress != null)
                return false;
        } else if (!deliveryAddress.equals(other.deliveryAddress))
            return false;
        if (paymentMethod == null) {
            if (other.paymentMethod != null)
                return false;
        } else if (!paymentMethod.equals(other.paymentMethod))
            return false;
        if (cart == null) {
            if (other.cart != null)
                return false;
        } else if (!cart.equals(other.cart))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "PurchaseOrder [id=" + id + ", deliveryAddress=" + deliveryAddress + ", paymentMethod=" + paymentMethod
                + ", cart=" + cart + "]";
    }


    
    
}
