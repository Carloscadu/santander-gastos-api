package com.santander.api.services.impl;



import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.santander.api.entities.Gastos;
import com.santander.api.repositories.GastosRepository;
import com.santander.api.services.GastosService;

@Service
public class GastosServiceImpl implements GastosService {

	private static final Logger log = LoggerFactory.getLogger(GastosServiceImpl.class);
	
	@Autowired
	private GastosRepository gastosRepository;
	
	@Override
	public Gastos persistir(Gastos gasto){
		log.info("Persistindo gastos {}", gasto);
		return this.gastosRepository.save(gasto);
		
	}
	

	/*@Override
	public List<Gastos> buscarGastosPorIdCliente(Long idCliente){
		log.info("Buscando por gastos do Cliente: {}", idCliente);
		return this.gastosRepository.findByClienteId(idCliente);
	}*/
	
	@Override
	public Page<Gastos> buscarGastosPorIdCliente(Long idCliente, PageRequest pageRequest){
		log.info("Buscando por gastos do Cliente: {}", idCliente);
		return this.gastosRepository.findByClienteId(idCliente, pageRequest);
	}
	
}