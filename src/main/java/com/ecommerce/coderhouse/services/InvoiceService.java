package com.ecommerce.coderhouse.services;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.coderhouse.DateDTO;
import com.ecommerce.coderhouse.InvoiceDTO;
import com.ecommerce.coderhouse.model.Client;
import com.ecommerce.coderhouse.model.InvoiceItem;
import com.ecommerce.coderhouse.model.Product;
import com.ecommerce.coderhouse.model.Invoice;
import com.ecommerce.coderhouse.repositories.InvoiceRepository;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceItemServices invoiceItemServices;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;


    public List<Invoice> getAllInvoice(){
        return invoiceRepository.findAll();
    }

    public Optional<Invoice> getInvoiceById(Long invoiceId){
        return invoiceRepository.findById(invoiceId);
    }

    // public List<Invoice> getAllInvoiceByClientId(Long clientId){
    // }

    public Invoice createInvoice(InvoiceDTO invoiceDTO){
            String date;
            
            RestTemplate restTemplate = new RestTemplate();
            String fooResourceUrl
            = "http://worldclockapi.com/api/json/utc/now";

            ResponseEntity<DateDTO> response
            = restTemplate.getForEntity(fooResourceUrl, DateDTO.class);
            if(response.getBody().getCurrentDateTime() != null){
                date = response.getBody().getCurrentDateTime();
            }else{
                date = Instant.now().toString();
            }
            
            Optional<Client> invoiceClient = clientService.getClientById(invoiceDTO.getClientid());
            //CONTROLA:
            /// 3) SI EL CLIENTE NO EXISTE, RETORNA ERROR
            if(!invoiceClient.isPresent()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The clientid " + invoiceDTO.getClientid() + "does not exist in our records");   
            }else{
                Invoice newInvoice = new Invoice();

                List<InvoiceItem> invoicesItemsToAdd = new ArrayList<InvoiceItem>();
                List<Product> productsItemsToUpdate = new ArrayList<Product>();
    
                invoiceDTO.getInvoiceItems().forEach(invoiceItem->{
    
                    Optional<Product> productItem =  productService.getProductById(invoiceItem.getProductid());
                    //CONTROLA:
                    /// 4) SI UNO DE LOS PRODUCTOS NO EXISTE, RETORNA ERROR
                    /// 5) SI NO EXISTE STOCK PARA EL PRODUCTO, RETORNA INFORMANDO AL USUARIO
                    if(!productItem.isPresent()||productItem.get().getStock()<invoiceItem.getQuantity()){
                        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The product with id " + invoiceItem.getProductid() + " does not exist in our records or have No STOCK disponible");
                    }else{
                        productsItemsToUpdate.add(productItem.get());
                        double itemSubtotalToAdd = productItem.get().getPrice()*invoiceItem.getQuantity();
    
                        newInvoice.setTotal(newInvoice.getTotal()+itemSubtotalToAdd);
        
                        InvoiceItem invoiceItemToAdd = new InvoiceItem();
                        invoiceItemToAdd.setProductid(productItem.get().getId());
                        invoiceItemToAdd.setQuantity(invoiceItem.getQuantity());
                        invoiceItemToAdd.setItemSubtotal(itemSubtotalToAdd);
                        invoiceItemToAdd.setProductName(productItem.get().getName());
                        invoiceItemToAdd.setProductDescription(productItem.get().getDescription());
                        invoiceItemToAdd.setProductPrice(productItem.get().getPrice());
        
                        invoicesItemsToAdd.add(invoiceItemToAdd);
                    }
                });
    
                //Actualiza el stock. Persiste la INVOICE y los InvoiceItems
                newInvoice.setClient(invoiceClient.get());
                newInvoice.setDate(date);
    
                Invoice persistedNewInvoice = invoiceRepository.save(newInvoice);


                for (int index = 0; index < invoicesItemsToAdd.size(); index++) {

                    productsItemsToUpdate.get(index).setStock(productsItemsToUpdate.get(index).getStock()-invoicesItemsToAdd.get(index).getQuantity());
                    
                    productService.updateProduct(productsItemsToUpdate.get(index).getId(), productsItemsToUpdate.get(index));
    
                    
                    invoicesItemsToAdd.get(index).setInvoice(persistedNewInvoice);
                    invoiceItemServices.createInvoiceItem(invoicesItemsToAdd.get(index));
                }

                persistedNewInvoice.setInvoiceItems(invoicesItemsToAdd);
    
                return persistedNewInvoice;
                
            }
    }
}
