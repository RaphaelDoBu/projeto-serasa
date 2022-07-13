package com.pessoa.serasa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
public class Score {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String descricao;
	
	@Min(0)
	private int inicial;
	
	@Max(1000)
	private int ultimo;

	public Score(Long id, String descricao, int inicial, int ultimo) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.inicial = inicial;
		this.ultimo = ultimo;
	}

	public Score() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getInicial() {
		return inicial;
	}

	public void setInicial(int inicial) {
		this.inicial = inicial;
	}

	public int getUltimo() {
		return ultimo;
	}

	public void setUltimo(int ultimo) {
		this.ultimo = ultimo;
	}
	
}
