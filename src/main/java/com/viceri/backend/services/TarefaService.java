package com.viceri.backend.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.viceri.backend.domain.Tarefa;
import com.viceri.backend.domain.Usuario;
import com.viceri.backend.dto.TarefaDTO;
import com.viceri.backend.repository.TarefaRepository;
import com.viceri.backend.repository.UsuarioRepository;

@Service
public class TarefaService {
	@Autowired
	private TarefaRepository tarefaRepository;
	@Autowired
	private UsuarioRepository usuarioRepository;

	public Tarefa inserirTarefa(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}

	public List<Tarefa> pesquisarTarefa() {
		return tarefaRepository.findAll();
	}

	public void removerTarefa(Long id) {
		tarefaRepository.deleteById(id);
	}

	public Optional<Tarefa> pesquisarTarefaPorId(Long id) {
		return tarefaRepository.findById(id);
	}

	public List<Tarefa> pesquisarPorStatus(String prioridade) {
		return tarefaRepository.findByPrioridade(prioridade);
	}

	public List<Tarefa> statusExiste(String prioridade) {
		return tarefaRepository.findByPrioridade(prioridade);
	}

	public Tarefa buscar(Long id) {
		Optional<Tarefa> tarefa = tarefaRepository.findById(id);
		if (tarefa.isPresent()) {
			return tarefa.get();
		}
		throw new IllegalArgumentException("ID não encontrado. ");
	}

	public Tarefa inserir(Tarefa tarefa) throws IOException {
		Optional<Usuario> user = usuarioRepository.findById(tarefa.getUsuario().getId());
		if (user.isPresent()) {
			tarefa.setUsuario(user.get());
			return tarefaRepository.save(tarefa);
		}
		throw new IllegalArgumentException("ID não encontrado. ");
	}

	public Tarefa updateTarefa(Tarefa tarefa) {
		Optional<Tarefa> t = tarefaRepository.findById(tarefa.getId());
		if (t.isPresent()) {
			t.get().setDescricaoTarefa(tarefa.getDescricaoTarefa());
			t.get().setPrioridade(tarefa.getPrioridade());
			t.get().setUsuario(tarefa.getUsuario());
			return tarefaRepository.save(t.get());
		}
		throw new IllegalArgumentException("ID não encontrado. ");
	}

	public boolean idExisteTarefa(Long id) {
		return tarefaRepository.existsById(id);
	}

	public List<TarefaDTO> listarPorUsuario(Long idUsuario) {
		List<Tarefa> tarefas = tarefaRepository.findByUsuarioId(idUsuario);
		List<TarefaDTO> tarefasDTO = new ArrayList<>();
		for (Tarefa tarefa : tarefas) {
			tarefasDTO.add(addDTO(tarefa));
		}
		return tarefasDTO;
	}

	public TarefaDTO addDTO(Tarefa tarefa) {
		TarefaDTO dto = new TarefaDTO();
		dto.setId(tarefa.getId());
		dto.setDescricaoTarefa(tarefa.getDescricaoTarefa());
		dto.setPrioridade(tarefa.getPrioridade());
		dto.setUsuario(tarefa.getUsuario());
		return dto;

	}
}
