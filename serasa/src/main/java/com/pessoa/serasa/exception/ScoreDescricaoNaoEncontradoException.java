package com.pessoa.serasa.exception;

public class ScoreDescricaoNaoEncontradoException extends RuntimeException{
	
	private static final long serialVersionUID = 715123334545454L;
	
	public ScoreDescricaoNaoEncontradoException(String texto) {
		super(texto);
	}
}
