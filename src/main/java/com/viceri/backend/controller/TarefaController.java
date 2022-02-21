package com.viceri.backend.controller;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.viceri.backend.domain.Tarefa;
import com.viceri.backend.domain.Usuario;
import com.viceri.backend.dto.TarefaDTO;
import com.viceri.backend.services.TarefaService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/tarefas")
public class TarefaController {

	// @AuthenticationPrincipal Usuario logado no método post?

	@Autowired
	private TarefaService tarefaService;

	@ApiOperation(value = "postar tarefa")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Tarefa obj) throws IOException {
		obj = tarefaService.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "pesquisar tarefa via id")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Tarefa> find(@PathVariable Long id) {
		Tarefa obj = tarefaService.buscar(id);
		return ResponseEntity.ok().body(obj);
	}

	@ApiOperation(value = "atualizar tarefa via id, " + "não precisa preencher todos os campos, "
			+ "apenas o que deseje alterar")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody TarefaDTO tarefa, @PathVariable Long id) {
		Tarefa obj = tarefaService.fromDTO(tarefa);
		obj.setId(id);
		obj = tarefaService.update(obj);
		return ResponseEntity.noContent().build();
	}

	// pesquisar por tarefa de usuario
	@GetMapping("/filtrar/{idUsuario}")
	public List<TarefaDTO> listarPorUsuario(@PathVariable Long idUsuario) {
		return tarefaService.listarPorUsuario(idUsuario);
	}

	@ApiOperation(value = "pesquisar por prioridade - alta, média ou baixa")
	@GetMapping(path = "/find")
	public ResponseEntity<List<Tarefa>> findByPrioridade(@RequestParam String prioridade) {
		return ResponseEntity.ok(tarefaService.pesquisarPorStatus(prioridade));
	}

	@GetMapping("/todas")
	public List<Tarefa> listar() {
		return tarefaService.listar();
	}
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		if (!tarefaService.idExisteTarefa(id)) {
			return ResponseEntity.notFound().build();
		}
		tarefaService.removerTarefa(id);
		return ResponseEntity.noContent().build();
	}
}
	


