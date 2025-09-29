package com.pauliane.todolist.service;

import java.util.List;

import com.pauliane.todolist.api.dto.TarefaDTO;

public interface TarefaService {

    TarefaDTO criar(TarefaDTO dto);

    List<TarefaDTO> listar();

    TarefaDTO buscarPorId(Long id);

    TarefaDTO atualizar(Long id, TarefaDTO dto);

    void deletar(Long id);
}

