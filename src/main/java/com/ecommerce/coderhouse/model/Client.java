package com.ecommerce.coderhouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="clients")
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_client")
    private Long id;

    @Column(name="document_type", nullable = false, updatable = false)
    private String documentType;

    @Column(name="document_number", nullable = false, updatable = false)
    private String documentNumber;

    @Column(name="iva_situation")
    private String ivaSituation;

    @Column(nullable = false)
    private String fullname;

    @Column(nullable = false)
    private String email;

    @Column
    private String address;

    @ManyToOne
    private Ecommerce ecommerce;

    public Client() {
    } 

    public Client(String documentType, String documentNumber, String ivaSituation, String fullname, String email,
            String address, Ecommerce ecommerce) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.ivaSituation = ivaSituation;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
        this.ecommerce = ecommerce;
    }

    //getters & setters
    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getIvaSituation() {
        return ivaSituation;
    }

    public void setIvaSituation(String ivaSituation) {
        this.ivaSituation = ivaSituation;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
