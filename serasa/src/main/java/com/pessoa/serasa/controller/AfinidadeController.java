package com.pessoa.serasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pessoa.serasa.model.Afinidade;
import com.pessoa.serasa.service.AfinidadeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
public class AfinidadeController {
	
	@Autowired
	private AfinidadeService afinidadeService;
	
	@PostMapping("/afinidade")
	@ApiOperation("Criar uma afinidade")
	@ApiResponses({ @ApiResponse(code = 201, message = "Afinidade salva com sucesso") })
	public ResponseEntity<Afinidade> criarAfinidade(@RequestBody Afinidade afinidade) {
		return new ResponseEntity<Afinidade>(afinidadeService.criar(afinidade), HttpStatus.CREATED);
	}
}
