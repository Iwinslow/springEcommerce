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
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_product")
    private Long id;

    @Column(nullable = false, unique = true, updatable = false)
    private String codigo;

    @Column(nullable = false)
    private String name;
    
    @Column
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false, updatable = false)
    private int unit;

    @ManyToOne
    @JoinColumn(name = "ecommerce")
    private Ecommerce ecommerce;

    public Product() {
    }


    public Product(String codigo, String name, String description, double price, int stock, int unit,
            Ecommerce ecommerce) {
        this.codigo = codigo;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.unit = unit;
        this.ecommerce = ecommerce;
    }

    //getters & setters
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unidad) {
        this.unit = unidad;
    }

}
