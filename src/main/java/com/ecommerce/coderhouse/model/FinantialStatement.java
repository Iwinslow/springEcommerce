package com.ecommerce.coderhouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
// import jakarta.persistence.MapsId;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        long temp;
        temp = Double.doubleToLongBits(totalSales);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalIVA);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(totalIIBB);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + invoicesIssued;
        result = prime * result + ((ecommerce == null) ? 0 : ecommerce.hashCode());
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
        FinantialStatement other = (FinantialStatement) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (Double.doubleToLongBits(totalSales) != Double.doubleToLongBits(other.totalSales))
            return false;
        if (Double.doubleToLongBits(totalIVA) != Double.doubleToLongBits(other.totalIVA))
            return false;
        if (Double.doubleToLongBits(totalIIBB) != Double.doubleToLongBits(other.totalIIBB))
            return false;
        if (invoicesIssued != other.invoicesIssued)
            return false;
        if (ecommerce == null) {
            if (other.ecommerce != null)
                return false;
        } else if (!ecommerce.equals(other.ecommerce))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "FinantialStatement [id=" + id + ", totalSales=" + totalSales + ", totalIVA=" + totalIVA + ", totalIIBB="
                + totalIIBB + ", invoicesIssued=" + invoicesIssued + ", ecommerce=" + ecommerce + "]";
    }

    

}
