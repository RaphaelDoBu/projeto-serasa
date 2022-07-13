package com.pessoa.serasa.exception;

public class AfinidadeNaoEncontradaException extends RuntimeException {
	
	private static final long serialVersionUID = 782665653232323L;
	
	public AfinidadeNaoEncontradaException(String texto) {
		super(texto);
	}

}
