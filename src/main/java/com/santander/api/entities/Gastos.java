package com.santander.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;


//import org.springframework.data.jpa.repository.Temporal;  //@Temporal(TemporalType.DATE)

@Entity
@Table(name="gastos")
public class Gastos implements Serializable {

	private static final long serialVersionUID = -8901225836534802102L;
	
	private Long id;
	private Cliente cliente;
	private String descricao;
	private Double valor;
	private Date dataGasto;
	private Date dataAtualizacao;
	
	public Gastos() {
	}

    @Override
	public String toString() {
		return "Gastos [id=" + id + ", cliente=" + cliente + ", descricao=" + descricao + ", valor=" + valor
				+ ", dataGasto=" + dataGasto + ", dataAtualizacao=" + dataAtualizacao + "]";
	}


	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name="descricao",nullable =false)
	public String getDescrião() {
		return descricao;
	}

	public void setDescrião(String descrião) {
		this.descricao = descrião;
	}

	@Column(name="valor",nullable =false)
	public Double getValor() {
		return valor;
	}
	

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Column(name="data_gasto",nullable =false)
	public Date getDataGasto() {
		return dataGasto;
	}
	
	public void setDataGasto(Date dataGasto) {
		this.dataGasto = dataGasto;
	}
	
	@Column(name="data_atualizacao",nullable =false)
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	
	public void setDataAtualizacao(Date dataAtualizacao) {
		this.dataAtualizacao = dataAtualizacao;
	}
	
	
	@PrePersist
	public void prePersist() {
		final Date atual= new Date();
		dataGasto=atual;
		dataAtualizacao=atual;
	}

	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@ManyToOne(fetch= FetchType.EAGER)
	//@JoinColumn(name = "cliente_id" )
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	}
