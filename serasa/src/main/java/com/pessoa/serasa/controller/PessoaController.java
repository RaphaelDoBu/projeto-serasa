package com.pessoa.serasa.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.pessoa.serasa.dto.PessoaDTO;
import com.pessoa.serasa.model.Pessoa;
import com.pessoa.serasa.service.PessoaService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
@RequestMapping("/pessoa")
@Api("API Pessoas")
public class PessoaController {

	@Autowired
	private PessoaService pessoaService;

	@PostMapping
	@ApiOperation("Criar uma pessoa")
	@ApiResponses({ @ApiResponse(code = 201, message = "Pessoa salva com sucesso")})
	public ResponseEntity<Pessoa> criarPessoa(@Valid @RequestBody Pessoa pessoa) {
		return new ResponseEntity<Pessoa>(pessoaService.criar(pessoa), HttpStatus.CREATED);
	}

	@GetMapping("{id}")
	@ApiOperation("Buscar detalhes da pessoa por Id")
	@ApiResponses({ @ApiResponse(code = 200, message = "Pessoa encontrada"),
			@ApiResponse(code = 204, message = "Pessoa não encontrado para ID informado") })
	public ResponseEntity<PessoaDTO> buscarPessoaPorId(@PathVariable("id") Long id) {
		return new ResponseEntity<PessoaDTO>(pessoaService.buscarPessoaPorId(id), HttpStatus.OK);
	}

	@GetMapping
	@ApiOperation("Buscar detalhes de todas as pessoas")
	@ApiResponses({ @ApiResponse(code = 200, message = "Pessoas encontradas"),
			@ApiResponse(code = 204, message = "Não existem pessoas cadastradas") })
	public ResponseEntity<List<PessoaDTO>> buscarPessoas() {
		return new ResponseEntity<List<PessoaDTO>>(pessoaService.buscarPessoas(), HttpStatus.OK);
	}
}
