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
@Table(name="invoice")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_invoice")
    private Long id;

    @Column(name="tax_iibb", nullable = false, updatable = false)
    private String taxIIBB;

    @Column(name="tax_iva", nullable = false, updatable = false)
    private String taxIVA;

    @OneToOne
    @JoinColumn(name = "purchase_order_id")
    private PurchaseOrder purchaseOrder;

    public Invoice() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTaxIIBB() {
        return taxIIBB;
    }

    public void setTaxIIBB(String taxIIBB) {
        this.taxIIBB = taxIIBB;
    }

    public String getTaxIVA() {
        return taxIVA;
    }

    public void setTaxIVA(String taxIVA) {
        this.taxIVA = taxIVA;
    }

    public PurchaseOrder getPurchaseOrder() {
        return purchaseOrder;
    }

    public void setPurchaseOrder(PurchaseOrder purchaseOrder) {
        this.purchaseOrder = purchaseOrder;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((taxIIBB == null) ? 0 : taxIIBB.hashCode());
        result = prime * result + ((taxIVA == null) ? 0 : taxIVA.hashCode());
        result = prime * result + ((purchaseOrder == null) ? 0 : purchaseOrder.hashCode());
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
        Invoice other = (Invoice) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (taxIIBB == null) {
            if (other.taxIIBB != null)
                return false;
        } else if (!taxIIBB.equals(other.taxIIBB))
            return false;
        if (taxIVA == null) {
            if (other.taxIVA != null)
                return false;
        } else if (!taxIVA.equals(other.taxIVA))
            return false;
        if (purchaseOrder == null) {
            if (other.purchaseOrder != null)
                return false;
        } else if (!purchaseOrder.equals(other.purchaseOrder))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Invoice [id=" + id + ", taxIIBB=" + taxIIBB + ", taxIVA=" + taxIVA + ", purchaseOrder=" + purchaseOrder
                + "]";
    }

    

}
