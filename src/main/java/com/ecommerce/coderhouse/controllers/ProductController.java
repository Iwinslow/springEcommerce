package com.ecommerce.coderhouse.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.coderhouse.model.Product;

import com.ecommerce.coderhouse.services.ProductService;

@RestController
@RequestMapping(value = "/api/product")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ProductController {
    @Autowired
    private ProductService service;

    /*
    GET /product/{id}
    Obtiene los datos del Cliente con id indicado en la URL
     */
    @GetMapping(path = "/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) throws Exception {
        return this.service.getProductById(id);
    }

    /*
    GET /cliente/all
    // Obtiene todos los clientes registrados
    //  */
    @GetMapping(path = "/all")
    public List<Product> getAllProducts() throws Exception {
        return this.service.getAllProducts();
    }

     /*
     POST /api/product
     Recibe en el body un objeto Product y lo persiste en la base de datos MySql
     Ejemplo:
     {
        "codigo": "321456988",
        "name": "Teclado luminoso Corsair",
        "description": "Un teclado con luces muy copadas",
         "price": 60000.00,
          "stock": 20,
          "unit": "UNIDADES"
     }
      */
    @PostMapping
    public Product createRealState(@RequestBody Product product) throws Exception {
        return this.service.createProduct(product);
    }
}
