package com.ecommerce.coderhouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.coderhouse.model.Invoice;
import com.ecommerce.coderhouse.repositories.InvoiceRepository;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;


    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Long invoiceId){
        return invoiceRepository.findById(invoiceId);
    }

    // public List<Invoice> getAllInvoiceByClientId(Long clientId){
    // }

    public Invoice createInvoice(Invoice invoice){
        return invoiceRepository.save(invoice);
    }
}
