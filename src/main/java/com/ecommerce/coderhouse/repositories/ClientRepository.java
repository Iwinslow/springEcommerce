package com.ecommerce.coderhouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.coderhouse.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long>{
    
}
