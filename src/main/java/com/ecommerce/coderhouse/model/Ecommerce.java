package com.ecommerce.coderhouse.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="ecommerces")
public class Ecommerce {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_ecommerce")
    private Long id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false, unique = true, updatable = false)
    private String cuit;

    @Column(nullable = false)
    private String address;

    @OneToOne(mappedBy = "ecommerce")
    private FinantialStatement finantialStatement;

    @OneToMany(mappedBy = "ecommerce")
    private ArrayList<Product> productList;

    @OneToMany(mappedBy = "ecommerce")
    private ArrayList<Client> clientList;

    public Ecommerce() {
    }

    public Ecommerce(String name, String cuit, String address, List<Product> productList, List<Client> clientList,
            FinantialStatement finantialStatement) {
        this.name = name;
        this.cuit = cuit;
        this.address = address;
        this.productList = new ArrayList<Product>();
        this.clientList = new ArrayList<Client>();
        this.finantialStatement = new FinantialStatement();
    }

    //getters & setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
