package com.santander.api.repositories;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.santander.api.entities.Cliente;
import com.santander.api.entities.Gastos;
import com.santander.api.enums.PerfiEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class GastosRepositoryTest {
	//Dados do Cliente
	private static final String userName = "carlos";
	private static final String nome = "carlos";
	private static final String senha = "12345";
	//private Cliente iddCliente; // para receber o ID do cliente cadastrado
	//dados do Gasto
	private static final String descricao = "Descrição de gastos para teste";
	private static final Double valor = (double) 100;
	//private static final String categoria = null;
	Cliente cliente = new Cliente();
	Cliente id_cliente = new Cliente();
	private Long id_cli;
	
		
	@Autowired
	private GastosRepository gastosRepository;
	
	@Autowired
	private ClientesRepository clientesRepository;

	

	@Before
	public void setUp() throws Exception{	
		Cliente idCliente = this.clientesRepository.save(obterCliente());
		id_cli = idCliente.getId();;
		this.gastosRepository.save(obterGasto(idCliente));
	}
	
	@After
	public final void tearDown() {
		this.gastosRepository.deleteAll();
	}

	//testar paginação e resolver problema
	/*@Test
	public void testBuscarGastosPorClientee() {
	 	PageRequest page = new PageRequest(0, 10);
		Page<Gastos> gastos = this.gastosRepository.findByClienteId(id_cli, page);
		assertEquals(1, gastos.getTotalElements());
		
	} */ //primeiro
	
	@Test
	public void testBuscarGastosPorCliente() {
		List<Gastos> Gastos = this.gastosRepository.findByClienteId(id_cli);
		assertEquals(1, Gastos.size());	
		
	}
	
	public Cliente obterCliente() {
		cliente.setNome(nome);
		cliente.setUserName(userName);
		cliente.setPasword(senha);
		cliente.setPerfil(PerfiEnum.ROLE_ADMIN);
		return cliente;
	}
	public Gastos obterGasto(Cliente cliente) {
		Gastos gastos = new Gastos();
		gastos.setDescrião(descricao);
		gastos.setValor(valor);
		gastos.setCliente(cliente);
		return gastos;
	}
	
}
