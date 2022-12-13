package com.ecommerce.coderhouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="cart_items")
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


    

    public CartItem() {
    }


    

    public CartItem(Product cartId, Product productId, int quantity) {
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getCartId() {
        return cartId;
    }

    public void setCartId(Product cartId) {
        this.cartId = cartId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }




    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((cartId == null) ? 0 : cartId.hashCode());
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        result = prime * result + quantity;
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
        CartItem other = (CartItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (cartId == null) {
            if (other.cartId != null)
                return false;
        } else if (!cartId.equals(other.cartId))
            return false;
        if (productId == null) {
            if (other.productId != null)
                return false;
        } else if (!productId.equals(other.productId))
            return false;
        if (quantity != other.quantity)
            return false;
        return true;
    }



    @Override
    public String toString() {
        return "CartItem [id=" + id + ", cartId=" + cartId + ", productId=" + productId + ", quantity=" + quantity
                + "]";
    }
    
    
    
}
