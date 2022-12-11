package com.ecommerce.coderhouse.model;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_cart")
    private Long id;

    //Cart states = pending (initial), confirm(transaction finished)
    @Column(nullable = false)
    private String state;

    @OneToOne
    @JoinColumn(name = "id_client")
    private Client client;

    @OneToMany
    private ArrayList<CartItem> cartItems;

    @Column(nullable = false)
    private double total;

    public Cart() {
    }

    public Cart(String state, Client client, ArrayList<CartItem> cartItems, String total) {
        this.state = "pending";
        this.client = new Client();
        this.cartItems = new ArrayList<CartItem>();
        this.total = 0.00;
    }

    
    //getters & setters
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public ArrayList<CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(ArrayList<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }


}
