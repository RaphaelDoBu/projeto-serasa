package com.pessoa.serasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pessoa.serasa.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
