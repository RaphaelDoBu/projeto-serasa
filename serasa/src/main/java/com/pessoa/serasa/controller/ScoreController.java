package com.pessoa.serasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.pessoa.serasa.model.Score;
import com.pessoa.serasa.service.ScoreService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
public class ScoreController {
	
	@Autowired
	private ScoreService scoreService;
	
	@PostMapping("/score")
	@ApiOperation("Criar um score")
	@ApiResponses({ @ApiResponse(code = 201, message = "Score salvo com sucesso") })
	public ResponseEntity<Score> criarScore(@RequestBody Score score){
		return new ResponseEntity<Score>(scoreService.criarScore(score), HttpStatus.CREATED);
	}
}
