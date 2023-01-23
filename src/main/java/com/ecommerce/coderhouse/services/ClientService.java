package com.ecommerce.coderhouse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.coderhouse.IdsListWrapper;
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

    public Client updateClient(Long clientId, Client newClient){
        return clientRepository.findById(clientId).map(client->{
            //CLIENT ATTRIBUTE "documentType", "documentNumber" AND "fullname" ARE updatable = false
            if (newClient.getIvaSituation() != null) {
                client.setIvaSituation(newClient.getIvaSituation());
            }
            if (newClient.getEmail() != null) {
                client.setEmail(newClient.getEmail());
            }
            if (newClient.getAddress() !=null) {
                client.setAddress(newClient.getAddress());
            }
            
            return clientRepository.save(client);
        }).orElseGet(()->{
            newClient.setId(clientId);
            return clientRepository.save(newClient);
        });
    }

    public void deleteClient(IdsListWrapper idsListWrapper){
        clientRepository.deleteAllById(idsListWrapper.getIdsList());
    }

}
