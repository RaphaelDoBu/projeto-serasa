package com.pessoa.serasa.exception.handler;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.pessoa.serasa.exception.AfinidadeNaoEncontradaException;
import com.pessoa.serasa.exception.PessoaNaoEncontradaException;
import com.pessoa.serasa.exception.ScoreDescricaoNaoEncontradoException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static final String CAUSE = "CAUSE: {} : {}";
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	@ExceptionHandler(PessoaNaoEncontradaException.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<StandardError> pessoaNaoEncontradaException(PessoaNaoEncontradaException e, HttpServletRequest req) {
		StandardError err = new StandardError(HttpStatus.NO_CONTENT.value(), e.getMessage(), req.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(err);
	}
	
	@ExceptionHandler(AfinidadeNaoEncontradaException.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<StandardError> afinidadeNaoEncontradaException(AfinidadeNaoEncontradaException e, HttpServletRequest req) {

		StandardError err = new StandardError(HttpStatus.NO_CONTENT.value(), e.getMessage(), "No content", req.getRequestURI());
	    
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(err);
	}
	
	@ExceptionHandler(ScoreDescricaoNaoEncontradoException.class)
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public ResponseEntity<StandardError> scoreDescricaoNaoEncontradoException(ScoreDescricaoNaoEncontradoException e, HttpServletRequest req) {

		StandardError err = new StandardError(HttpStatus.NO_CONTENT.value(), e.getMessage(), "No content", req.getRequestURI());
	    
		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(err);
	}
	
}
