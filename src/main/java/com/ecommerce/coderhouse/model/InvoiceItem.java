package com.ecommerce.coderhouse.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="invoice_items")
public class InvoiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_cartitem")
    private Long id;


    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "invoiceid", nullable = false)
    private Invoice invoice;

    @Column(nullable = false, updatable = false)
    private Long productid;

    @Column(nullable = false, updatable = false)
    private String productName;
    
    @Column
    private String productDescription;

    @Column(nullable = false)
    private double productPrice;


    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double itemSubtotal;

    public InvoiceItem() {
    }

    public InvoiceItem(Invoice invoice, Long productid, String productName, String productDescription,
            double productPrice, int quantity, double itemSubtotal) {
        this.invoice = invoice;
        this.productid = productid;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.quantity = quantity;
        this.itemSubtotal = itemSubtotal;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }

    public Long getProductid() {
        return productid;
    }

    public void setProductid(Long productid) {
        this.productid = productid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getItemSubtotal() {
        return itemSubtotal;
    }

    public void setItemSubtotal(double itemSubtotal) {
        this.itemSubtotal = itemSubtotal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((invoice == null) ? 0 : invoice.hashCode());
        result = prime * result + ((productid == null) ? 0 : productid.hashCode());
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + ((productDescription == null) ? 0 : productDescription.hashCode());
        long temp;
        temp = Double.doubleToLongBits(productPrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + quantity;
        temp = Double.doubleToLongBits(itemSubtotal);
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
        InvoiceItem other = (InvoiceItem) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (invoice == null) {
            if (other.invoice != null)
                return false;
        } else if (!invoice.equals(other.invoice))
            return false;
        if (productid == null) {
            if (other.productid != null)
                return false;
        } else if (!productid.equals(other.productid))
            return false;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (productDescription == null) {
            if (other.productDescription != null)
                return false;
        } else if (!productDescription.equals(other.productDescription))
            return false;
        if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
            return false;
        if (quantity != other.quantity)
            return false;
        if (Double.doubleToLongBits(itemSubtotal) != Double.doubleToLongBits(other.itemSubtotal))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "InvoiceItem [id=" + id + ", invoice=" + invoice + ", productid=" + productid + ", productName="
                + productName + ", productDescription=" + productDescription + ", productPrice=" + productPrice
                + ", quantity=" + quantity + ", itemSubtotal=" + itemSubtotal + "]";
    }

    
   
    
}
