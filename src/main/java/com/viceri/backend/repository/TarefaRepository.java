package com.viceri.backend.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.viceri.backend.domain.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long>{
	public Optional<Tarefa> findById(Long id);
	public List<Tarefa> findByStatus(String status);
	public List<Tarefa> findByUsuarioId(Long idUsuario);
}