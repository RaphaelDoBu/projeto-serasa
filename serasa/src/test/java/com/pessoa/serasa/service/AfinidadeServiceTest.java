package com.pessoa.serasa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import com.pessoa.serasa.exception.AfinidadeNaoEncontradaException;
import com.pessoa.serasa.model.Afinidade;
import com.pessoa.serasa.repository.AfinidadeRepository;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class AfinidadeServiceTest {
	
	private static final String NORDESTE = "nordeste";

	@InjectMocks
	private AfinidadeService afinidadeService;
	
	@Mock
	private AfinidadeRepository afinidadeRepository;

	@Test
	public void criarAfinidadeComSucesso() {
		Afinidade afinidade = new Afinidade();
		List<String> estados = List.of("PB", "PE", "MA", "CE", "PI", "RN", "AL", "SE", "BA");

		afinidade.setRegiao(NORDESTE);
		afinidade.setEstados(estados);
		
		when(afinidadeRepository.save(afinidade)).thenReturn(afinidade);
		Afinidade afinidadeCriada = afinidadeService.criar(afinidade);
		
		assertEquals(afinidadeCriada.getRegiao(), NORDESTE);
		verify(afinidadeRepository).save(afinidade);
	}
	
	@Test
	public void buscarEstadosComSucesso() {
		Afinidade afinidade = new Afinidade();
		List<String> estados = List.of("PB", "PE", "MA", "CE", "PI", "RN", "AL", "SE", "BA");

		afinidade.setRegiao(NORDESTE);
		afinidade.setEstados(estados);
		
		when(afinidadeRepository.findById(NORDESTE)).thenReturn(Optional.of(afinidade));
		List<String> estadosEncontrados = afinidadeService.buscarEstados(NORDESTE);
		
		assertEquals(estadosEncontrados, estados);
		verify(afinidadeRepository).findById(NORDESTE);
	}
	
	@Test
	public void buscarEstadosAfinidadeNaoEncontradaException() {
		assertThrows(AfinidadeNaoEncontradaException.class, () -> afinidadeService.buscarEstados(NORDESTE));
	}
}
