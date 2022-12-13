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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((cuit == null) ? 0 : cuit.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
        result = prime * result + ((finantialStatement == null) ? 0 : finantialStatement.hashCode());
        result = prime * result + ((productList == null) ? 0 : productList.hashCode());
        result = prime * result + ((clientList == null) ? 0 : clientList.hashCode());
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
        Ecommerce other = (Ecommerce) obj;
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
        if (cuit == null) {
            if (other.cuit != null)
                return false;
        } else if (!cuit.equals(other.cuit))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        if (finantialStatement == null) {
            if (other.finantialStatement != null)
                return false;
        } else if (!finantialStatement.equals(other.finantialStatement))
            return false;
        if (productList == null) {
            if (other.productList != null)
                return false;
        } else if (!productList.equals(other.productList))
            return false;
        if (clientList == null) {
            if (other.clientList != null)
                return false;
        } else if (!clientList.equals(other.clientList))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Ecommerce [id=" + id + ", name=" + name + ", cuit=" + cuit + ", address=" + address
                + ", finantialStatement=" + finantialStatement + ", productList=" + productList + ", clientList="
                + clientList + "]";
    }

    

}
