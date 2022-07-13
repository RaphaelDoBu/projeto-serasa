package com.pessoa.serasa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoa.serasa.exception.ScoreDescricaoNaoEncontradoException;
import com.pessoa.serasa.model.Score;
import com.pessoa.serasa.repository.ScoreRepository;

@Service
public class ScoreService {
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	public Score criarScore(Score score) {
		return scoreRepository.save(score);
	}
	
	public String scoreDescricao(int score) {
		String descricao = scoreRepository.scoreDescricao(score);
		if(descricao == null) {
			throw new ScoreDescricaoNaoEncontradoException("Não existe descrição para o score informado!");
		}
		return descricao;
	}

}
