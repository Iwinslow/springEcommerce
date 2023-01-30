package com.ecommerce.coderhouse;

import java.util.List;

public class InvoiceDTO {
    
    private Long clientid;
    
    private List<InvoiceItemDTO> invoiceItems;

    public InvoiceDTO() {
    }

    public Long getClientid() {
        return clientid;
    }

    public void setClientid(Long clientid) {
        this.clientid = clientid;
    }

    public List<InvoiceItemDTO> getInvoiceItems() {
        return invoiceItems;
    }

    public void setInvoiceItems(List<InvoiceItemDTO> invoiceItems) {
        this.invoiceItems = invoiceItems;
    }

    @Override
    public String toString() {
        return "InvoiceDTO [clientid=" + clientid + ", invoiceItems=" + invoiceItems + "]";
    }


    
}
