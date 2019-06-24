package com.santander.api.repositories;

import java.util.List;


import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.santander.api.entities.Gastos;

@NamedQueries({
	@NamedQuery(name="GastosRepository.findByClienteId",
			query = "SELECT e FROM gastos e WHERE e.cliente_id = :idCliente")
})


public interface GastosRepository extends JpaRepository<Gastos, Long> {

	List<Gastos> findByClienteId(@Param("idCliente") Long idCliente);
	Page<Gastos> findByClienteId(@Param("idCliente") Long idCliente, PageRequest pageRequest);
	
	Gastos findById(String id);
	
	

}
