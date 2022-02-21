package com.viceri.backend.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.viceri.backend.domain.Usuario;
import com.viceri.backend.services.UsuarioService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

	@Autowired
	private UsuarioService servicoUsuario;
	
	@GetMapping
	public List<Usuario> obterTodos(){
		return servicoUsuario.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Optional<Usuario> obter(@PathVariable("id") Long id){
		return servicoUsuario.obterPorId(id);
	}
	
	@PostMapping
	public Usuario adicionar(@RequestBody Usuario usuario) {
		return servicoUsuario.adicionar(usuario);
	}
}