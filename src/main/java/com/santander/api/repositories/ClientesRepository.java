package com.santander.api.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.santander.api.entities.Cliente;


public interface ClientesRepository extends JpaRepository<Cliente, Long>{

	Optional<Cliente> findById(String id);
	Cliente findByUserName(String  userName);
	Cliente findByUserNameOrId(String  userName, String Id);
    
}
