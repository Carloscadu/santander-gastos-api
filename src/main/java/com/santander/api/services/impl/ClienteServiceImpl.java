package com.santander.api.services.impl;


import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santander.api.entities.Cliente;
import com.santander.api.repositories.ClientesRepository;
import com.santander.api.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	private static final Logger log = LoggerFactory.getLogger(ClienteServiceImpl.class);

	@Autowired
	private ClientesRepository clientesRepository;
	
	@Override
	public Optional<Cliente> buscarPorUserName(String userName) {
		log.info("Buscando por {}",userName);
		return Optional.ofNullable(clientesRepository.findByUserName(userName));
	}
	
	
	@Override
	public Cliente persistir(Cliente cliente) {
		log.info("Persistindo dados do Cliente{}",cliente);
		return this.clientesRepository.save(cliente);
	}

	
}
