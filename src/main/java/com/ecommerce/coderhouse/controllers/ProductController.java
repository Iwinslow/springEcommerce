package com.ecommerce.coderhouse.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.coderhouse.IdsListWrapper;
import com.ecommerce.coderhouse.model.Product;

import com.ecommerce.coderhouse.services.ProductService;

@RestController
@RequestMapping(value = "/api/product")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
class ProductController {
    @Autowired
    private ProductService service;

    /*
    GET /product/{id}
    Obtiene los datos del Producto con id indicado en la URL
     */
    @GetMapping(path = "/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) throws Exception {
        Optional<Product> productFound = this.service.getProductById(id);
        if(productFound.isPresent()){
            return productFound;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with ID " + id + " was not found");
        }   
    }
    
    /*
    GET /product/all
    // Obtiene todos los Productos registrados
    //  */
    @GetMapping(path = "/all")
    public List<Product> getAllProducts() throws Exception {
        List<Product> productList = this.service.getAllProducts();
        if(productList.size()>0){
            return productList;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no products to list"); 
        }
        
    }

     /*
     POST /api/product
     Recibe en el body un objeto Product y lo persiste en la base de datos MySql
     Ejemplo OK:
     {
        "name": "Auricular luminoso Corsair",
        "description": "Un auricular con luces muy copadas",
         "price": 60000.00,
          "stock": 20,
          "unit": "UNIDADES",
          "image":"https://app.contabilium.com/files/explorer/20302/Productos-Servicios/concepto-9235894.jpg"
     }
      */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product createProduct(@RequestBody Product product) throws Exception{
        if(product.getName()==null || product.getPrice()==0 || product.getStock()==0 || product.getUnit()==null ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body must include name, price, stock and unit");   
        }else{
            return this.service.createProduct(product);
        }
    }

     /*
     PUT /api/product/{id}
     Recibe en el body las keys que quieran ser actualizadas respecto al producto especifico (el pasado por params {id})
     REMEMBER! -> PRODUCT ATTRIBUTES "name" AND "unit" ARE updatable = false
     Ejemplo OK:
     {
        "description": "Un teclado con luces muy copadas de china",
         "price": 3000.00,
          "stock": 5
     }
    */
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) throws Exception{
        if(product.getName()!=null||product.getUnit()!=null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product name or unit are not updatables");
        }else{
            return service.updateProduct(id, product);
        }
    }

     /*
     DELETE /api/product
     Recibe en el body un objeto con la key idsList, cuyo value es un array con los IDs de los productos a eliminar
     Ejemplo OK:
    {
        "idsList":[1, 3, 101]
    }
    */
    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@RequestBody IdsListWrapper idsListWrapper) throws Exception{
        try {
            this.service.deleteProduct(idsListWrapper);
            return new ResponseEntity<>("Products have been deleted", HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Must include key 'idsList' with an Array of numbers as a value in request body");
        }
    }
}
