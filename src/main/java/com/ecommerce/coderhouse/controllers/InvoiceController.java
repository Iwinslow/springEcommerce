package com.ecommerce.coderhouse.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.server.ResponseStatusException;


import com.ecommerce.coderhouse.InvoiceDTO;
import com.ecommerce.coderhouse.model.Invoice;
import com.ecommerce.coderhouse.services.InvoiceService;


@RestController
@RequestMapping(value = "/api/invoice")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;


    /*
    GET /invoice/{id}
    Obtiene los datos del Invoice con id indicado en la URL
     */
    @GetMapping(path = "/{id}")
    public Optional<Invoice> getProductById(@PathVariable Long id) throws Exception {
        Optional<Invoice> invoiceFound = this.invoiceService.getInvoiceById(id);
        if(invoiceFound.isPresent()){
            return invoiceFound;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invoice with ID " + id + " was not found");
        }   
    }
    
    /*
    GET /invoice/all
    // Obtiene todos los Invoice registrados
    //  */
    @GetMapping(path = "/all")
    public List<Invoice> getAllProducts() throws Exception {
        List<Invoice> invoiceList = invoiceService.getAllInvoice();
        if(invoiceList.size()>0){
            return invoiceList;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no invoices to list"); 
        }
        
    }

     /*
     POST /api/invoice
     Recibe en el body un objeto Product y lo persiste en la base de datos MySql
     Ejemplo OK:
     {
        "clientid": 1,
        "invoiceItems":[
            {
                "productid": 1,
                "quantity": 1
            },
            {
                "productid": 2,
                "quantity": 4
            }
        ]
     }
      */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Invoice createInvoice(@RequestBody InvoiceDTO invoiceDTO) throws Exception{
        //CONTROLA:
        /// 1) SI NO INCLUYE CLIENTID, RETORNA ERROR
        /// 2) SI NO INCLUYE NINGUN PRODUCTO, RETORNA ERROR
        if(invoiceDTO.getClientid()==null || invoiceDTO.getInvoiceItems().size()==0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body must include clientid and invoiceItems wich must contain as least one product");   
        }else{
            return invoiceService.createInvoice(invoiceDTO);
    }
    }
}
