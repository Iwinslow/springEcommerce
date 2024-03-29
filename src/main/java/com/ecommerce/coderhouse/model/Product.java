package com.ecommerce.coderhouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_product")
    private Long id;

    @Column(nullable = false, updatable = false)
    private String name;
    
    @Column
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false, updatable = false)
    private String unit;

    @Column
    private String image;

    public Product() {
    }


    public Product(String codigo, String name, String description, double price, int stock, String unit, String image) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.unit = unit;
        this.image = image;
    }

    //getters & setters
    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
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

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unidad) {
        this.unit = unidad;
    }

    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((description == null) ? 0 : description.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + stock;
        result = prime * result + ((unit == null) ? 0 : unit.hashCode());
        result = prime * result + ((image == null) ? 0 : image.hashCode());
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
        Product other = (Product) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        if (stock != other.stock)
            return false;
        if (unit == null) {
            if (other.unit != null)
                return false;
        } else if (!unit.equals(other.unit))
            return false;
        if (image == null) {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", stock="
                + stock + ", unit=" + unit + ", image=" + image + "]";
    }

    
}
