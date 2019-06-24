package com.santander.api.services.impl;

import static org.junit.Assert.assertNotNull;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.santander.api.entities.Gastos;
import com.santander.api.repositories.GastosRepository;
import com.santander.api.services.GastosService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class GastosServiceImplTest {
	
	@MockBean
	private GastosRepository gastosRepository;
	
	@Autowired
	private GastosService gastosService;
	
	@Before
	public void setUp() throws Exception{
		BDDMockito.given(this.gastosRepository.save(Mockito.any(Gastos.class))).willReturn(new Gastos());

		BDDMockito
		.given(this.gastosRepository.findByClienteId(Mockito.anyLong(), Mockito.any(PageRequest.class)))
		.willReturn(new PageImpl<Gastos>( new ArrayList<Gastos>()));
		
	}
	
	
	@Test
	public void testBuscarPorGatosPorIdCliente() {
		Page<Gastos> gastos = this.gastosService.buscarGastosPorIdCliente(1L, new PageRequest(0,10));
		assertNotNull(gastos);

	}

	@Test
	public void testPersistir() {
		Gastos gastos = this.gastosService.persistir(new Gastos());
		assertNotNull(gastos);
		}

}
