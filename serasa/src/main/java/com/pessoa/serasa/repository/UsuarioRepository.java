package com.pessoa.serasa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pessoa.serasa.model.Usuario;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByLogin(String login);
}