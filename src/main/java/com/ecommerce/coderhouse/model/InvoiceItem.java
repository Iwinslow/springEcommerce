package com.ecommerce.coderhouse.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @OneToOne
    @JoinColumn(name = "productid", nullable = false)
    private Product product;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double itemSubtotal;

    public InvoiceItem() {
    }

    public InvoiceItem(Invoice invoice, Product product, int quantity, double itemSubtotal) {
        this.invoice = invoice;
        this.product = product;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
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
        result = prime * result + ((product == null) ? 0 : product.hashCode());
        result = prime * result + quantity;
        long temp;
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
        if (product == null) {
            if (other.product != null)
                return false;
        } else if (!product.equals(other.product))
            return false;
        if (quantity != other.quantity)
            return false;
        if (Double.doubleToLongBits(itemSubtotal) != Double.doubleToLongBits(other.itemSubtotal))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "InvoiceItem [id=" + id + ", invoice=" + invoice + ", product=" + product + ", quantity=" + quantity
                + ", itemSubtotal=" + itemSubtotal + "]";
    }

    
    
}
