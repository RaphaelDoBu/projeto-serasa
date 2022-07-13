package com.pessoa.serasa.exception;

public class PessoaNaoEncontradaException extends RuntimeException {
	
	private static final long serialVersionUID = 946456421313212313L;
	
	public PessoaNaoEncontradaException(String texto) {
		super(texto);
	}
}
