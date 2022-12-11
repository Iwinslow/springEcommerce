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

    

}
