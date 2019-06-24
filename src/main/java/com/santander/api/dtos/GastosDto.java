package com.santander.api.dtos;

public class GastosDto {

	private Long id;
	private Long idCliente;
	private String descricao;
	private Double valor;
	private String dataGasto;
	private String dataAtualizacao;
	
	public GastosDto() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getDataGasto() {
		return dataGasto;
	}

	public void setDataGasto(String dataGasto) {
		this.dataGasto = dataGasto;
	}

	public String getDataAtualizacao() {
		return dataAtualizacao;
	}

	public void setDataAtualizacao(String dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}

}
