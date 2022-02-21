package com.viceri.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viceri.backend.dto.LoginRequest;
import com.viceri.backend.dto.LoginResponse;
import com.viceri.backend.service.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/login")
public class LoginController {

	@Autowired
	private UsuarioService servicoUsuario;

	@PostMapping
	public LoginResponse login(@RequestBody LoginRequest request) {
		return servicoUsuario.logar(request.getEmail(), request.getSenha());
	}

}