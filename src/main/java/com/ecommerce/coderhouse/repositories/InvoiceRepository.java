package com.ecommerce.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.coderhouse.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
}
