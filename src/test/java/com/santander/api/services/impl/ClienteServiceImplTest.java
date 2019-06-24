package com.santander.api.services.impl;

import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.santander.api.entities.Cliente;
import com.santander.api.repositories.ClientesRepository;
import com.santander.api.services.ClienteService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClienteServiceImplTest {

	@MockBean
	private ClientesRepository clientesRepository;
	
	@Autowired
	private ClienteService clienteServece;
	
	@Before
	public void setUp() throws Exception{
		BDDMockito.given(this.clientesRepository.save(Mockito.any(Cliente.class))).willReturn(new Cliente());

		BDDMockito.given(this.clientesRepository.findByUserName(Mockito.anyString())).willReturn(new Cliente());
	}
	
	
	private static final String UserName = "carlos";
	
	
	@Test
	public void testBuscarPorUserName() {
		Optional<Cliente> cliente = this.clienteServece.buscarPorUserName(UserName);
		
		assertTrue(cliente.isPresent());
	}

	@Test
	public void testPersistir() {
		Cliente cliente = this.clienteServece.persistir(new Cliente());
		
		assertNotNull(cliente);
		}

}
