package com.pessoa.serasa.exception;

public class SenhaInvalidaException extends RuntimeException {

	private static final long serialVersionUID = 36548526565656L;
	
    public SenhaInvalidaException(){
        super("Senha Inválida");
    }
}