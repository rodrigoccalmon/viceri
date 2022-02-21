package com.viceri.backend.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.viceri.backend.domain.Usuario;
import com.viceri.backend.dto.LoginResponse;
import com.viceri.backend.exception.EmailException;
import com.viceri.backend.repository.UsuarioRepository;
import com.viceri.backend.security.JWTService;

@Service
public class UsuarioService {

	private static final String headerPrefix = "Bearer ";

	@Autowired
	private UsuarioRepository repositorioUsuario;

	@Autowired
	private JWTService jwtService;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private PasswordEncoder passwordEnconder;

	public List<Usuario> obterTodos() {
		return repositorioUsuario.findAll();
	}

	public Optional<Usuario> obterPorId(Long id) {
		return repositorioUsuario.findById(id);
	}

	public Usuario adicionar(Usuario usuario) {
		usuario.setId(null);
		if (repositorioUsuario.findByEmail(usuario.getEmail()).isPresent()) {
			throw new EmailException("E-mail já cadastrado. Favor verificar. ");
		}
		String senha = passwordEnconder.encode(usuario.getSenha());
		usuario.setSenha(senha);
		return repositorioUsuario.save(usuario);
	}

	public LoginResponse logar(String email, String senha) {

		Authentication autenticacao = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(email, senha, Collections.emptyList()));

		SecurityContextHolder.getContext().setAuthentication(autenticacao);

		String token = headerPrefix + jwtService.gerarToken(autenticacao);

		var usuario = repositorioUsuario.findByEmail(email);

		return new LoginResponse(token, usuario.get());
	}

}