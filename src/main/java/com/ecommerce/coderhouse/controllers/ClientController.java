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
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.ecommerce.coderhouse.IdsListWrapper;
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
        Optional<Client> clientFound = this.service.getClientById(id);
        if(clientFound.isPresent()){
            return clientFound;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client with ID " + id + " was not found");
        }
     
    }

    /*
    GET /cliente/all
    Obtiene todos los clientes registrados
     */
    @GetMapping(path = "/all")
    public List<Client> getAllClients() throws Exception {
        List<Client> clientList = this.service.getAllClients();
        if(clientList.size()>0){
            return clientList;
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "There are no Clients to list"); 
        }
        
    }

    /*
    POST /api/client
    Recibe en el body un objeto Cliente y lo persiste en la base de datos MySql
    Ejemplo:
    {
        "documentType": "DNI",
        "documentNumber": "99999999",
        "fullname": "Bill Gates",
        "email":"this_is_billgates@gmail.com",
        "address": "Calle falsa 123",
        "ivaSituation": "Monotributo"
    }
     */
    @PostMapping
    public Client createRealState(@RequestBody Client client) throws Exception {
        if(client.getDocumentType()==null || client.getDocumentNumber()==null || client.getFullname()==null || client.getEmail()==null ){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Request body must include documentType, documentNumber, fullname and email");   
        }else{
            return this.service.createClient(client);
        }
    }

      /*
     PUT /api/client/{id}
     Recibe en el body las keys que quieran ser actualizadas respecto al cliente especifico (el pasado por params {id})
     REMEMBER! -> CLIENT ATTRIBUTES "documentType", "documentNumber" AND "fullname" ARE updatable = false
     Ejemplo OK:
     {
        "ivaSituation": "Responsable inscripto",
         "email": "this_is_billgates@hotmail.com",,
          "address": "Nueva Calle falsa 321"
     }
    */
    @PutMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Client updateProduct(@PathVariable Long id, @RequestBody Client client) throws Exception{
        if(client.getDocumentType()!=null||client.getDocumentNumber()!=null||client.getFullname()!=null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Client fullname, documentType or documentNumber are not updatables");
        }else{
            return service.updateClient(id, client);
        }
    }

     /*
     DELETE /api/client
     Recibe en el body un objeto con la key idsList, cuyo value es un array con los IDs de los clientes a eliminar
     Ejemplo OK:
    {
        "idsList":[1, 2]
    }
    */
    @DeleteMapping
    public ResponseEntity<String> deleteProduct(@RequestBody IdsListWrapper idsListWrapper) throws Exception{
        try {
            this.service.deleteClient(idsListWrapper);
            return new ResponseEntity<>("Clients have been deleted", HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Must include key 'idsList' with an Array of numbers as a value in request body");
        }
         
    }


}
