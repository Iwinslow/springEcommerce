package com.ecommerce.coderhouse.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="invoices")
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_invoice")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "clientid")
    private Client client;

    @Column(nullable = false)
    private String date;

    @OneToMany(mappedBy = "invoice")
    private List<InvoiceItem> invoiceItems;

    @Column(nullable = false)
    private double total;


    public Invoice() {
    }


    public Invoice(Client client, String date, List<InvoiceItem> invoiceItems, double total) {
        this.client = client;
        this.date = date;
        this.invoiceItems = invoiceItems;
        this.total = total;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Client getClient() {
        return client;
    }


    public void setClient(Client client) {
        this.client = client;
    }


    public String getDate() {
        return date;
    }


    public void setDate(String date) {
        this.date = date;
    }


    public List<InvoiceItem> getInvoiceItems() {
        return invoiceItems;
    }


    public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }


    public double getTotal() {
        return total;
    }


    public void setTotal(double total) {
        this.total = total;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((client == null) ? 0 : client.hashCode());
        result = prime * result + ((date == null) ? 0 : date.hashCode());
        result = prime * result + ((invoiceItems == null) ? 0 : invoiceItems.hashCode());
        long temp;
        temp = Double.doubleToLongBits(total);
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
        Invoice other = (Invoice) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (client == null) {
            if (other.client != null)
                return false;
        } else if (!client.equals(other.client))
            return false;
        if (date == null) {
            if (other.date != null)
                return false;
        } else if (!date.equals(other.date))
            return false;
        if (invoiceItems == null) {
            if (other.invoiceItems != null)
                return false;
        } else if (!invoiceItems.equals(other.invoiceItems))
            return false;
        if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
            return false;
        return true;
    }


    @Override
    public String toString() {
        return "Invoice [id=" + id + ", client=" + client + ", date=" + date + ", invoiceItems=" + invoiceItems
                + ", total=" + total + "]";
    }

    

}
