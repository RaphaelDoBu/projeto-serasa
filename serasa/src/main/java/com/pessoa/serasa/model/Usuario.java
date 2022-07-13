package com.pessoa.serasa.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "login")
	@NotEmpty(message = "{campo.login.obrigatorio}")
	private String login;
	
	@Column(name = "senha")
	@NotEmpty(message = "{campo.senha.obrigatorio}")
	private String senha;
	
	private boolean admin;
	
	public Usuario(Integer id, @NotEmpty(message = "{campo.login.obrigatorio}") String login,
			@NotEmpty(message = "{campo.senha.obrigatorio}") String senha, boolean admin) {
		super();
		this.id = id;
		this.login = login;
		this.senha = senha;
		this.admin = admin;
	}
	
	public Usuario() {
		super();
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public boolean isAdmin() {
		return admin;
	}
	
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
}