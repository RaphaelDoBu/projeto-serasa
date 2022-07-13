package com.pessoa.serasa.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Afinidade {
	
	@Id
	private String regiao;
	
	@ElementCollection
	private List<String> estados;

	public Afinidade(String regiao, List<String> estados) {
		super();
		this.regiao = regiao;
		this.estados = estados;
	}

	public Afinidade() {
		super();
	}

	public String getRegiao() {
		return regiao;
	}

	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}

	public List<String> getEstados() {
		return estados;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}

}
