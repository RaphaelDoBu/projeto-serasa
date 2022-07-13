package com.pessoa.serasa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import com.pessoa.serasa.exception.ScoreDescricaoNaoEncontradoException;
import com.pessoa.serasa.model.Score;
import com.pessoa.serasa.repository.ScoreRepository;

@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
public class ScoreServiceTest {
	
	@InjectMocks
	private ScoreService scoreService;
	
	@Mock
	private ScoreRepository scoreRepository;
	
	@Test
	public void criarScoreComSucesso() {
		Score score = new Score();
		
		score.setId(1L);
		score.setDescricao("Insuficiente");
		score.setInicial(0);
		score.setUltimo(200);
		
		when(scoreRepository.save(score)).thenReturn(score);
		Score scoreCriado = scoreService.criarScore(score);
				
		assertEquals(score.getDescricao(), scoreCriado.getDescricao());
		verify(scoreRepository).save(score);
	}
	
	@Test
	public void scoreDescricaoRetornado() {
		when(scoreRepository.scoreDescricao(700)).thenReturn("Aceitável");
		String scoreDescricao = scoreService.scoreDescricao(700);
		
		assertEquals(scoreDescricao, "Aceitável");
	}
	
	@Test
	public void scoreDescricaoScoreDescricaoNaoEncontradoException() {
		assertThrows(ScoreDescricaoNaoEncontradoException.class, () -> scoreService.scoreDescricao(700));
	}
}
