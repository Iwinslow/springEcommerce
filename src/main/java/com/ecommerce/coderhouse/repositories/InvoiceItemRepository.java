package com.ecommerce.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.coderhouse.model.InvoiceItem;

public interface InvoiceItemRepository extends JpaRepository<InvoiceItem, Long> {
    
}