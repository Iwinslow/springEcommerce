package com.ecommerce.coderhouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="carts")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_cart")
    private Long id;

    @Column(nullable = false)
    private Boolean confirmed;

    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;

    // @OneToMany
    // private ArrayList<CartItem> cartItems;

    @Column(nullable = false)
    private double total;

    public Cart() {
    }

    public Cart(Client client) {
        this.confirmed = false;
        this.client = client;
        this.total = 0.00;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(Boolean confirmed) {
        this.confirmed = confirmed;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((confirmed == null) ? 0 : confirmed.hashCode());
        result = prime * result + ((client == null) ? 0 : client.hashCode());
        long temp;
        temp = Double.doubleToLongBits(total);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Cart other = (Cart) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (confirmed == null) {
            if (other.confirmed != null)
                return false;
        } else if (!confirmed.equals(other.confirmed))
            return false;
        if (client == null) {
            if (other.client != null)
                return false;
        } else if (!client.equals(other.client))
            return false;
        if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Cart [id=" + id + ", confirmed=" + confirmed + ", client=" + client + ", total=" + total + "]";
    }
    

}
