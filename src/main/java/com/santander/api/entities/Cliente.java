package com.santander.api.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.santander.api.enums.PerfiEnum;

@Entity
@Table(name ="clientes")
public class Cliente implements Serializable{


	private static final long serialVersionUID = 8416845190478076173L;
	
	private long id;
	private String nome;
	private String userName;
	private String pasword;
	private PerfiEnum perfil;
	private List<Gastos> gasto;
	
	public Cliente() {
		
	}

	@Id
	@Column(name="id",nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Column(name="nome",nullable = false)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="user_name",nullable = false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="pasword",nullable = false)
	public String getPasword() {
		return pasword;
	}

	public void setPasword(String pasword) {
		this.pasword = pasword;
	}

	@OneToMany(mappedBy = "cliente", fetch= FetchType.LAZY)
	public List<Gastos> getGasto() {
		return gasto;
	}

	public void setGasto(List<Gastos> gasto) {
		this.gasto = gasto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Enumerated(EnumType.STRING)
	@Column(name = "perfil",nullable = false)
	public PerfiEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfiEnum perfil) {
		this.perfil = perfil;
	}
	
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", userName=" + userName + ", pasword=" + pasword + ", perfil="
				+ perfil + "]";
	}
	
	
}
