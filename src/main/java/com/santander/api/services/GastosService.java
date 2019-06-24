package com.santander.api.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import com.santander.api.entities.Gastos;

public interface GastosService {

	/**Retorna todos os gastos de um Cliente dado O id do Usuario
	 * 
	 * @param id
	 * @Return Optonal<Gastos>
	 */
	//List<Gastos> buscarGastosPorIdCliente(Long idCliente);
	

	/**Retorna todos os gastos de um Cliente dado O id do Usuario
	 * 
	 * @param id
	 * @Return Optonal<Gastos>
	 */
	Page<Gastos> buscarGastosPorIdCliente(Long idCliente, PageRequest pageRequest);
	
	/**Cadastra um novo Gasto
	 * 
	 * @param gastos
	 * @Return Gastos
	 */
	Gastos persistir(Gastos gasto);
}
