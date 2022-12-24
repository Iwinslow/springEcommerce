package com.ecommerce.coderhouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.coderhouse.model.Client;
import com.ecommerce.coderhouse.repositories.ClientRepository;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;
    
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    public Optional<Client> getClientById(Long idClient){
        return clientRepository.findById(idClient);
    }

    public Client createClient(Client client){
        return clientRepository.save(client);
    }

}
