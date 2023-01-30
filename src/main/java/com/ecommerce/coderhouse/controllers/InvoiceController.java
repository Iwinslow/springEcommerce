package com.ecommerce.coderhouse.controllers;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.coderhouse.InvoiceDTO;
import com.ecommerce.coderhouse.model.Client;
import com.ecommerce.coderhouse.model.Invoice;
import com.ecommerce.coderhouse.model.InvoiceItem;
import com.ecommerce.coderhouse.model.Product;
import com.ecommerce.coderhouse.services.ClientService;
import com.ecommerce.coderhouse.services.InvoiceItemServices;
import com.ecommerce.coderhouse.services.InvoiceService;
import com.ecommerce.coderhouse.services.ProductService;


@RestController
@RequestMapping(value = "/api/invoice")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceItemServices invoiceItemServices;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ProductService productService;


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
    public Invoice createProduct(@RequestBody InvoiceDTO invoiceDTO) throws Exception{
        //CONTROLA:
        /// 1) SI NO INCLUYE CLIENTID, RETORNA ERROR
        /// 2) SI NO INCLUYE NINGUN PRODUCTO, RETORNA ERROR
        if(invoiceDTO.getClientid()==null || invoiceDTO.getInvoiceItems().size()==0){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body must include clientid and invoiceItems wich must contain as least one product");   
        }else{
            RestTemplate restTemplate = new RestTemplate();
            String fooResourceUrl
            = "http://worldclockapi.com/api/json/utc/now";

            ResponseEntity<String> response
            = restTemplate.getForEntity(fooResourceUrl, String.class);

            String date = Instant.now().toString();

            System.out.println("////////////////////////////////");
            System.out.println("RESPONSE BODY");
            System.out.println(response.getBody());

         

            System.out.println("////////////////////////////////");
            System.out.println("Instant date");
            System.out.println(date);
            
            Optional<Client> invoiceClient = clientService.getClientById(invoiceDTO.getClientid());
            //CONTROLA:
            /// 3) SI EL CLIENTE NO EXISTE, RETORNA ERROR
            if(!invoiceClient.isPresent()){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The clientid " + invoiceDTO.getClientid() + "does not exist in our records");   
            }

            Invoice newInvoice = new Invoice();

            List<InvoiceItem> invoicesItemsToAdd = new ArrayList<InvoiceItem>();

            invoiceDTO.getInvoiceItems().forEach(invoiceItem->{

                Optional<Product> productItem =  productService.getProductById(invoiceItem.getProductid());
                //CONTROLA:
                /// 4) SI UNO DE LOS PRODUCTOS NO EXISTE, RETORNA ERROR
                if(!productItem.isPresent()){
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The product with id " + invoiceItem.getProductid() + "does not exist in our records");   
                }

                double itemSubtotalToAdd = productItem.get().getPrice()*invoiceItem.getQuantity();

                newInvoice.setTotal(newInvoice.getTotal()+itemSubtotalToAdd);

                InvoiceItem invoiceItemToAdd = new InvoiceItem();
                invoiceItemToAdd.setProduct(productItem.get());
                invoiceItemToAdd.setQuantity(invoiceItem.getQuantity());
                invoiceItemToAdd.setItemSubtotal(itemSubtotalToAdd);

                invoicesItemsToAdd.add(invoiceItemToAdd);
            });

            //Persiste la INVOICE y los InvoiceItems
            newInvoice.setClient(invoiceClient.get());
            newInvoice.setDate(date);


            Invoice persistedNewInvoice = invoiceService.createInvoice(newInvoice);

            invoicesItemsToAdd.forEach(invoiceItemToAdd ->{
                invoiceItemToAdd.setInvoice(persistedNewInvoice);
                invoiceItemServices.createInvoiceItem(invoiceItemToAdd);
            });

            return invoiceService.getInvoiceById(persistedNewInvoice.getId()).get();
            
    }

    }

}