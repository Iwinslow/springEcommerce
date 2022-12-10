package com.ecommerce.coderhouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="finantialStatement")
public class FinantialStatement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_finstatement")
    private Long id;

    @Column(name="total_sales")
    private double totalSales;

    @Column(name="total_iva")
    private double totalIVA;


    @Column(name="total_iibb")
    private double totalIIBB;

    @Column(name="invoices_issued")
    private int invoicesIssued;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_ecommerce")
    private Ecommerce ecommerce;


    public FinantialStatement(){
        this.totalSales = 0.00;
        this.invoicesIssued = 0;
        this.totalIVA = 0.00;
        this.totalIIBB = 0.00;
    }

    //getters & setters
    public double getTotalSales() {
        return totalSales;
    }

    public int getNumberOfInvoicesIssued() {
        return invoicesIssued;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

    public void setNumberOfInvoicesIssued(int invoicesIssued) {
        this.invoicesIssued = invoicesIssued;
    }

    public double getTotalIVA() {
        return totalIVA;
    }


    public void setTotalIVA(double totalIVA) {
        this.totalIVA = totalIVA;
    }


    public double getTotalIIBB() {
        return totalIIBB;
    }


    public void setTotalIIBB(double totalIIBB) {
        this.totalIIBB = totalIIBB;
    }

}
