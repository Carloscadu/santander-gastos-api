package com.santander.api.services;

import java.util.Optional;

import com.santander.api.entities.Cliente;

public interface ClienteService {

	/**Retorna um Cliente dado O nome de Usuario
	 * 
	 * @param userName
	 * @Return Optonal<Cliente>
	 */
	Optional<Cliente> buscarPorUserName(String userName);
	
	/**Cadastra um novo Cliente
	 * 
	 * @param cliente
	 * @Return Cliente
	 */
	Cliente persistir(Cliente cliente);
}
