package com.ecommerce.coderhouse.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    @Column(nullable = false, updatable = false)
    private String fullname;

    @Column(nullable = false)
    private String email;

    @Column
    private String address;


    public Client() {
    } 

    public Client(String documentType, String documentNumber, String ivaSituation, String fullname, String email,
            String address) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.ivaSituation = ivaSituation;
        this.fullname = fullname;
        this.email = email;
        this.address = address;
    }

    //getters & setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((documentType == null) ? 0 : documentType.hashCode());
        result = prime * result + ((documentNumber == null) ? 0 : documentNumber.hashCode());
        result = prime * result + ((ivaSituation == null) ? 0 : ivaSituation.hashCode());
        result = prime * result + ((fullname == null) ? 0 : fullname.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((address == null) ? 0 : address.hashCode());
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
        Client other = (Client) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (documentType == null) {
            if (other.documentType != null)
                return false;
        } else if (!documentType.equals(other.documentType))
            return false;
        if (documentNumber == null) {
            if (other.documentNumber != null)
                return false;
        } else if (!documentNumber.equals(other.documentNumber))
            return false;
        if (ivaSituation == null) {
            if (other.ivaSituation != null)
                return false;
        } else if (!ivaSituation.equals(other.ivaSituation))
            return false;
        if (fullname == null) {
            if (other.fullname != null)
                return false;
        } else if (!fullname.equals(other.fullname))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (address == null) {
            if (other.address != null)
                return false;
        } else if (!address.equals(other.address))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Client [id=" + id + ", documentType=" + documentType + ", documentNumber=" + documentNumber
                + ", ivaSituation=" + ivaSituation + ", fullname=" + fullname + ", email=" + email + ", address="
                + address + "]";
    }

    
}
