package com.ecommerce.coderhouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.coderhouse.model.InvoiceItem;
import com.ecommerce.coderhouse.repositories.InvoiceItemRepository;

@Service
public class InvoiceItemServices {

    @Autowired
    private InvoiceItemRepository invoiceItemRepository;


    public List<InvoiceItem> getAllInvoiceItems(){
        return invoiceItemRepository.findAll();
    }

    public Optional<InvoiceItem> getInvoiceItemById(Long invoiceItemId){
        return invoiceItemRepository.findById(invoiceItemId);
    }

    public InvoiceItem createInvoiceItem(InvoiceItem invoiceItem){
        return invoiceItemRepository.save(invoiceItem);
    }
}
