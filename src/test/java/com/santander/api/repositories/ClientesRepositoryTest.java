package com.santander.api.repositories;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.santander.api.entities.Cliente;
import com.santander.api.enums.PerfiEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ClientesRepositoryTest {
	
	private static final String userName = "carlos";
	private static final String nome = "carlos";
	private static final String senha = "12345";
	Cliente cliente = new Cliente();
	
	@Autowired
	private ClientesRepository clientesRepository;
	
	@Before
	public void setUp() throws Exception{
		cliente.setNome(nome);
		cliente.setUserName(userName);
		cliente.setPasword(senha);
		cliente.setPerfil(PerfiEnum.ROLE_ADMIN);
		this.clientesRepository.save(cliente);
		cliente.getId();
	}
	
	@After
	public final void tearDown() {
		this.clientesRepository.deleteAll();
	}
	
	@Test
	public void testBuscarClienteForUserName() {
		Cliente cliente = this.clientesRepository.findByUserName(userName);
		assertEquals(userName, cliente.getUserName());
	}
	
	
}
