package com.pessoa.serasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.pessoa.serasa.dto.CredenciaisDTO;
import com.pessoa.serasa.dto.TokenDTO;
import com.pessoa.serasa.exception.SenhaInvalidaException;
import com.pessoa.serasa.model.Usuario;
import com.pessoa.serasa.secutiry.jwt.JwtService;
import com.pessoa.serasa.service.UsuarioServiceImpl;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.validation.Valid;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
    private UsuarioServiceImpl usuarioService;
    
	@Autowired
	private PasswordEncoder passwordEncoder;
    
	@Autowired
	private JwtService jwtService;

    @PostMapping
    @ApiOperation("Criar um usuário")
	@ApiResponses({ @ApiResponse(code = 201, message = "Usuário salvo com sucesso")})
    public ResponseEntity<Usuario> salvar(@RequestBody @Valid Usuario usuario){
        String senhaCriptografada = passwordEncoder.encode(usuario.getSenha());
        usuario.setSenha(senhaCriptografada);
        return new ResponseEntity<Usuario>(usuarioService.salvar(usuario), HttpStatus.CREATED);
    }

    @PostMapping("/auth")
    @ApiOperation("Autenticar usuário")
  	@ApiResponses({ @ApiResponse(code = 201, message = "Usuário autenticado com sucesso")})
    public ResponseEntity<TokenDTO> autenticar(@RequestBody CredenciaisDTO credenciais){
        try{
            Usuario usuario = new Usuario();
            usuario.setLogin(credenciais.getLogin());
            usuario.setSenha(credenciais.getSenha());
            UserDetails userDetails = usuarioService.autenticar(usuario);
            String token = jwtService.gerarToken(usuario);
            return new ResponseEntity<TokenDTO>(new TokenDTO(usuario.getLogin(), token), HttpStatus.CREATED);

        } catch (UsernameNotFoundException | SenhaInvalidaException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, e.getMessage());
        }
    }
}