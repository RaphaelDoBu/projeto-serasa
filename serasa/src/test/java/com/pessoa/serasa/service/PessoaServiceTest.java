package com.pessoa.serasa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import com.pessoa.serasa.dto.PessoaDTO;
import com.pessoa.serasa.exception.AfinidadeNaoEncontradaException;
import com.pessoa.serasa.exception.PessoaNaoEncontradaException;
import com.pessoa.serasa.exception.ScoreDescricaoNaoEncontradoException;
import com.pessoa.serasa.model.Pessoa;
import com.pessoa.serasa.repository.PessoaRepository;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class PessoaServiceTest {
	
	@InjectMocks
	private PessoaService pessoaService; 
	
	@Mock
	private PessoaRepository pessoaRepository;
	
	@Mock
	private AfinidadeService afinidadeService;
	
	@Mock
	private ScoreService scoreService;
	
	@Test
	public void criarPessoaComSucesso() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Raphael");
		
		when(pessoaRepository.save(pessoa)).thenReturn(pessoa);
		Pessoa pessoaCriada = pessoaService.criar(pessoa);
		
		assertEquals(pessoaCriada.getNome(), "Raphael");
		verify(pessoaRepository).save(pessoa);
	}
	
	@Test
	public void criarPessoaAfinidadeNaoEncontradaException() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Raphael");
		
		when(afinidadeService.buscarEstados(pessoa.getEstado())).thenThrow(AfinidadeNaoEncontradaException.class);
		
		assertThrows(AfinidadeNaoEncontradaException.class, () -> pessoaService.criar(pessoa));
	}
	
	@Test
	public void criarPessoaScoreDescricaoNaoEncontradoException() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Raphael");
		
		when(scoreService.scoreDescricao(pessoa.getScore())).thenThrow(ScoreDescricaoNaoEncontradoException.class);
		
		assertThrows(ScoreDescricaoNaoEncontradoException.class, () -> pessoaService.criar(pessoa));
	}
	
	@Test
	public void buscarPessoaPorIdPessoaNaoEncontradaException() {		
		assertThrows(PessoaNaoEncontradaException.class, () -> pessoaService.buscarPessoaPorId(1L));
	}
	
	@Test
	public void buscarPessoaPorIdPessoaComSucesso() {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(1L);
		pessoa.setNome("Raphael");
		pessoa.setRegiao("nordeste");
		pessoa.setScore(700);
		
		List<String> estados = List.of("PB", "PE", "MA", "CE", "PI", "RN", "AL", "SE", "BA");
		
		PessoaDTO pessoaDTO = new PessoaDTO();
		pessoaDTO.setNome(pessoa.getNome());
		pessoaDTO.setEstados(estados);
		pessoaDTO.setScoreDescricao("Aceitável");
		
		when(pessoaRepository.findById(1L)).thenReturn(Optional.of(pessoa));
		when(afinidadeService.buscarEstados(pessoa.getRegiao())).thenReturn(estados);
		when(scoreService.scoreDescricao(pessoa.getScore())).thenReturn("Aceitável");

		PessoaDTO pessoalEncontrada = pessoaService.buscarPessoaPorId(1L);
		
		assertEquals(pessoalEncontrada.getNome(), pessoaDTO.getNome());
		assertEquals(pessoalEncontrada.getEstados(), estados);
	}
	
	@Test
	public void buscarPessoasComSucesso() {
		List<Pessoa> pessoas = new ArrayList<>();
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setId(1L);
		pessoa1.setNome("Raphael");
		pessoa1.setRegiao("nordeste");
		pessoa1.setScore(700);
		
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setId(2L);
		pessoa2.setNome("José");
		pessoa2.setRegiao("sudeste");
		pessoa2.setScore(900);
		
		pessoas.add(pessoa1);
		pessoas.add(pessoa2);
		when(pessoaRepository.findAll()).thenReturn(pessoas);
		
		List<PessoaDTO> pessoasDTO = pessoaService.buscarPessoas();
		
		assertFalse(pessoasDTO.isEmpty());
		assertEquals(pessoasDTO.get(0).getNome(), "Raphael");
		assertEquals(pessoasDTO.get(1).getNome(), "José");
	}
	
	@Test
	public void buscarPessoasPessoaNaoEncontradaException() {
		assertThrows(PessoaNaoEncontradaException.class, () -> pessoaService.buscarPessoas());
	}

}
