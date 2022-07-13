package com.pessoa.serasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.pessoa.serasa.model.Score;

public interface ScoreRepository extends JpaRepository<Score, Long>{
	
	@Query("select descricao from Score where inicial <= :score and ultimo >= :score")
	String scoreDescricao(int score);

}
