package com.santander.api.controller;


import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.santander.api.dtos.ClienteDto;
import com.santander.api.entities.Cliente;
import com.santander.api.enums.PerfiEnum;
import com.santander.api.responses.Response;
import com.santander.api.services.ClienteService;
import com.santander.api.utils.PasswordUtils;

@RestController
@RequestMapping("/api/cadastrar-cliente")
@CrossOrigin(origins = "*")
public class ClienteController {

	private static final Logger log = LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private ClienteService clienteService;
	
	public ClienteController() {
		
	}
	
	/**
	 * Cadastrar um Cliente no Sistema
	 * 
	 * 
	 * @param ClienteDto
	 * @param Result
	 * @param ResponseEntity<Response<ClienteDto>>
	 */
	@PostMapping
	public ResponseEntity<Response<ClienteDto>> cadastrar(@Valid @RequestBody ClienteDto clienteDto, BindingResult result) 
			throws NoSuchAlgorithmException{
		log.info("Cadastrando Cliente: {}", clienteDto.toString());
		Response<ClienteDto> response = new Response<ClienteDto>();
		
		validarDadosExistentes(clienteDto, result);
		Cliente cliente = this.converterDtoParaCliente(clienteDto, result);
		if(result.hasErrors()) {
			log.error("Erro ao valida Cliente: {},",result.getAllErrors());
			result.getAllErrors().forEach(error -> response.getErros().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		this.clienteService.persistir(cliente);
		response.setData(this.converterClienteParaDto(cliente));
		return ResponseEntity.ok(response);
	}
	/**
	 * Atualiza dados de um Cliente no Sistema
	 * 
	 * 
	 * @param ClienteDto
	 * @param Result
	 * @param ResponseEntity<Response<ClienteDto>>
	 */
	@PutMapping(value = "/{userName}")
	public ResponseEntity<Response<ClienteDto>> atualizar(@PathVariable("userName") String userName,@Valid @RequestBody ClienteDto clienteDto, BindingResult result) 
			throws NoSuchAlgorithmException{
		log.info("Atualizando dados do Cliente: {}", clienteDto.toString());
		Response<ClienteDto> response = new Response<ClienteDto>();
		
		Optional<Cliente> cliente =this.clienteService.buscarPorUserName(userName);
		if(!cliente.isPresent()) {
			result.addError(new ObjectError("Cliente","Cliente não encontrado."));
		}
		
		//atualizarCliente()
		//this.clienteService.persistir(cliente);
		//response.setData(this.converterClienteParaDto(cliente));
		return ResponseEntity.ok(response);
	}
	

	/**
	 * Verifica se o Cliente já existe nabase de dados
	 * 
	 * 
	 * @param ClienteDto
	 * @param Result
	 */
	private void validarDadosExistentes(ClienteDto clienteDto, BindingResult result){
		this.clienteService.buscarPorUserName(clienteDto.getUserName())
			.ifPresent(func -> result.addError(new ObjectError("Cliente", "Nome de Usuario já existente.")));
	}
	
	
	/**
	 * Converte os dados do DTO para Cliente
	 * 
	 * 
	 * @param ClienteDto
	 * @param Result
	 * 
	 */
	private Cliente converterDtoParaCliente(ClienteDto clienteDto, BindingResult result) throws NoSuchAlgorithmException{
		Cliente cliente = new Cliente();
		cliente.setNome(clienteDto.getNome());
		cliente.setUserName(clienteDto.getUserName());
		cliente.setPasword(PasswordUtils.gerarBCrypt(clienteDto.getSenha()));
		cliente.setPerfil(PerfiEnum.ROLE_USER);
		return cliente;
	}
	/**
	 * Converte os dados do DTO para Cliente
	 * 
	 * 
	 * @param ClienteDto
	 * @param Result
	 * 
	 */
	private ClienteDto converterClienteParaDto(Cliente cliente){
		ClienteDto clienteDto = new ClienteDto();
		clienteDto.setId(cliente.getId());
		clienteDto.setNome(cliente.getNome());
		clienteDto.setUserName(cliente.getUserName());
		return clienteDto;
	}
	
	
	/**
	 * Atualizar dados do Cliente
	 * 
	 * 
	 * @param Cliente
	 * @param ClienteDto
	 * @param Result
	 * @throws NoSuchAlgorithmException
	 * 
	 */
	private void atualizarDadosCliente(Cliente cliente, ClienteDto clienteDto, BindingResult result) throws NoSuchAlgorithmException{
		cliente.setNome(clienteDto.getNome());
		
		/*if(clienteDto.getSenha().ifPresent()){
			cliente.setPasword(PasswordUtils.gerarBCrypt(clienteDto.getSenha()));
		}*/
	}
	
	
	
}
