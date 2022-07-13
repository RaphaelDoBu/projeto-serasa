package com.pessoa.serasa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoa.serasa.exception.AfinidadeNaoEncontradaException;
import com.pessoa.serasa.model.Afinidade;
import com.pessoa.serasa.repository.AfinidadeRepository;

@Service
public class AfinidadeService {
	
	@Autowired
	private AfinidadeRepository afinidadeRepository;
	
	public Afinidade criar(Afinidade afinidade) {
		return afinidadeRepository.save(afinidade);
	}
	
	public List<String> buscarEstados(String regiao){
		Optional<Afinidade> afinidade = afinidadeRepository.findById(regiao);
		if(afinidade.isEmpty()) {
			throw new AfinidadeNaoEncontradaException("Afinidade não foi encontrada para região informada!");
		}
		return afinidade.get().getEstados();
	}

}
