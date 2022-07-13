package com.pessoa.serasa.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pessoa.serasa.dto.PessoaDTO;
import com.pessoa.serasa.exception.PessoaNaoEncontradaException;
import com.pessoa.serasa.model.Pessoa;
import com.pessoa.serasa.repository.PessoaRepository;

@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private AfinidadeService afinidadeService;
	
	@Autowired
	private ScoreService scoreService;
	
	public Pessoa criar(Pessoa pessoa) {
		afinidadeService.buscarEstados(pessoa.getRegiao());
		scoreService.scoreDescricao(pessoa.getScore());
		pessoa.setDataInclusao(new Date());
		return pessoaRepository.save(pessoa);
	}
	
	public PessoaDTO buscarPessoaPorId(Long id) {
		Optional<Pessoa> pessoa = pessoaRepository.findById(id);
		if(pessoa.isEmpty()) {
			throw new PessoaNaoEncontradaException("Id informado de pessoa não existe!");
		}
		
		PessoaDTO pessoaDTO = montarPessoaDTO(pessoa.get());
		return pessoaDTO;
	}
	
	public List<PessoaDTO> buscarPessoas(){
		List<Pessoa> pessoas = pessoaRepository.findAll();
		if(pessoas.isEmpty()) {
			throw new PessoaNaoEncontradaException("Não existem pessoas cadastradas!");		
		}
		
		List<PessoaDTO> pessoasDTO = new ArrayList<>();
		for(Pessoa p: pessoas) {
			PessoaDTO pessoaDTO = montarPessoaDTO(p);
			pessoasDTO.add(pessoaDTO);
		}
		return pessoasDTO;
	}

	public PessoaDTO montarPessoaDTO(Pessoa pessoa) {
		PessoaDTO pessoaDTO = new PessoaDTO();
		List<String> estados = afinidadeService.buscarEstados(pessoa.getRegiao());
		String scoreDescricao = scoreService.scoreDescricao(pessoa.getScore());
		
		pessoaDTO.setNome(pessoa.getNome());
		pessoaDTO.setIdade(pessoa.getIdade());
		pessoaDTO.setTelefone(pessoa.getTelefone());
		pessoaDTO.setEstados(estados);
		pessoaDTO.setScoreDescricao(scoreDescricao);
		return pessoaDTO;
	}
}
