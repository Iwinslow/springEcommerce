package com.ecommerce.coderhouse.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.coderhouse.model.Client;
import com.ecommerce.coderhouse.services.ClientService;

@RestController
@RequestMapping(value = "/api/client")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ClientController {
    @Autowired
    private ClientService service;
    /*
    GET /cliente/{id}
    Obtiene los datos del Cliente con id indicado en la URL
     */
    @GetMapping(path = "/{id}")
    public Optional<Client> getClientById(@PathVariable Long id) throws Exception {
        return this.service.getClientById(id);
    }

    /*
    GET /cliente/all
    Obtiene todos los clientes registrados
     */
    @GetMapping(path = "/all")
    public List<Client> getAllClients() throws Exception {
        return this.service.getAllClients();
    }

    /*
    POST /api/client
    Recibe en el body un objeto Cliente y lo persiste en la base de datos MySql
    Ejemplo:
    {
        "fullname": "Bill Gates",
        "documentType": "DNI",
        "documentNumber": "99999999",
        "email":"this_is_billgates@gmail.com",
        "address": "Calle falsa 123",
        "ivaSituation": "Monotributo"
    }
     */
    @PostMapping
    public Client createRealState(@RequestBody Client client) throws Exception {
        return this.service.createClient(client);
    }
}
