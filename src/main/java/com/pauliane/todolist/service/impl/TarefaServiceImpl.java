package com.pauliane.todolist.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.pauliane.todolist.api.dto.TarefaDTO;
import com.pauliane.todolist.api.exception.RegraNegocioException;
import com.pauliane.todolist.model.entity.Tarefa;
import com.pauliane.todolist.model.repository.TarefaRepository;
import com.pauliane.todolist.service.TarefaService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository repository;

    @Override
    public TarefaDTO criar(TarefaDTO dto) {
        Tarefa tarefa = converterParaEntidade(dto);
        return converterParaDTO(repository.save(tarefa));
    }
    
    @Override
    public List<TarefaDTO> listar() {
        return repository.findAll().stream()
            .map(this::converterParaDTO)
            .collect(Collectors.toList());
    }

    @Override
    public TarefaDTO buscarPorId(Long id) {
        Tarefa tarefa = repository.findById(id)
            .orElseThrow(() -> new RegraNegocioException("Tarefa não encontrada"));
        return converterParaDTO(tarefa);
    }


    @Override
    public TarefaDTO atualizar(Long id, TarefaDTO dto) {
        Tarefa tarefa = repository.findById(id)
            .orElseThrow(() -> new RegraNegocioException("Tarefa não encontrada"));
        tarefa.setNome(dto.getNome());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setStatus(dto.getStatus());
        tarefa.setObservacoes(dto.getObservacoes());
        return converterParaDTO(repository.save(tarefa));
    }

    @Override
    public void deletar(Long id) {
        repository.deleteById(id);
    }

    private TarefaDTO converterParaDTO(Tarefa tarefa) {
        return new TarefaDTO(
            tarefa.getId(),
            tarefa.getNome(),
            tarefa.getDescricao(),
            tarefa.getStatus(),
            tarefa.getObservacoes(),
            tarefa.getDataCriacao(),
            tarefa.getDataAtualizacao()
        );
    }

    private Tarefa converterParaEntidade(TarefaDTO dto) {
        return new Tarefa(
            dto.getId(),
            dto.getNome(),
            dto.getDescricao(),
            dto.getStatus(),
            dto.getObservacoes(),
            dto.getDataCriacao(),
            dto.getDataAtualizacao()
        );
    }
}
