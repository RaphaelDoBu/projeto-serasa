package com.pessoa.serasa.dto;

import java.util.List;

public class PessoaDTO {
	
	private String nome;
	
	private String telefone;
	
	private int idade;
	
	private String scoreDescricao;
	
	private List<String> estados;
	
	public PessoaDTO(String nome, String telefone, int idade, String scoreDescricao, List<String> estados) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
		this.scoreDescricao = scoreDescricao;
		this.estados = estados;
	}
	
	public PessoaDTO() {
		super();
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
	
	public List<String> getEstados() {
		return estados;
	}
	
	public void setEstados(List<String> estados) {
		this.estados = estados;
	}

	public String getScoreDescricao() {
		return scoreDescricao;
	}

	public void setScoreDescricao(String scoreDescricao) {
		this.scoreDescricao = scoreDescricao;
	}
	
}
