package com.santander.api.dtos;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class ClienteDto {

	private Long id;
	private String nome;
	private String userName;
	private String senha;
	
	public ClienteDto() {
		
	}

	@Override
	public String toString() {
		return "ClienteDto [id=" + id + ", nome=" + nome + ", userName=" + userName + ", senha=" + senha + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@NotEmpty(message = "Campo Obrigatório.")
	@Length(min = 3, max = 200, message = "Para ser valido o nome deve conter entre 3 e 200 caracteres.")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	@NotEmpty(message = "Campo Obrigatório.")
	@Length(min = 3, max = 200, message = "Para ser valido seu nome de usuario deve conter entre 3 e 200 caracteres.")
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	@NotEmpty(message = "Campo Obrigatório.")
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
