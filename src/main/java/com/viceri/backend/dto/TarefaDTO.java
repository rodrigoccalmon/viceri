package com.viceri.backend.dto;

import com.viceri.backend.domain.Tarefa;
import com.viceri.backend.domain.Usuario;

public class TarefaDTO {
	private Long id;
	private String descricaoTarefa;
	private String prioridade;
	private Usuario usuario;

	public TarefaDTO() {

	}

	public TarefaDTO(Long id, String descricaoTarefa, String prioridade, Usuario usuario) {
		super();
		this.id = id;
		this.descricaoTarefa = descricaoTarefa;
		this.prioridade = prioridade;
		this.usuario = usuario;
	}

	public TarefaDTO(Tarefa obj) {
		id = obj.getId();
		descricaoTarefa = obj.getDescricaoTarefa();
		prioridade = obj.getPrioridade();
		usuario = obj.getUsuario();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}

	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}

	public String getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
