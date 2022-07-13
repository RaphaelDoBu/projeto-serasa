package com.pessoa.serasa.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Pessoa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date dataInclusao;
	
	@NotBlank(message = "{campo.nome.obrigatorio}")
	private String nome;
	
	private String telefone;
	
	@Min(18)
	private int idade;
	
	private String cidade;
	
	private String estado;
	
	@NotBlank(message = "{campo.regiao.obrigatorio}")
	private String regiao;
	
	@Min(0)
	@Max(1000)
	private int score;

	public Pessoa(Long id, Date dataInclusao, String nome, String telefone, int idade, String cidade, String estado,
			String regiao, int score) {
		super();
		this.id = id;
		this.dataInclusao = dataInclusao;
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
		this.cidade = cidade;
		this.estado = estado;
		this.regiao = regiao;
		this.score = score;
	}

	public Pessoa() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
}
