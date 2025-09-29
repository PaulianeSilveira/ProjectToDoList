package com.pauliane.todolist.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.pauliane.todolist.api.dto.TarefaDTO;
import com.pauliane.todolist.model.entity.Tarefa;
import com.pauliane.todolist.model.enums.StatusTarefa;
import com.pauliane.todolist.model.repository.TarefaRepository;
import com.pauliane.todolist.service.impl.TarefaServiceImpl;

import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(MockitoExtension.class)
public class TarefaServiceImplTest {

    @Mock
    private TarefaRepository repository;

    @InjectMocks
    private TarefaServiceImpl service;

    @Test
    public void deveCriarTarefaComSucesso() {
        TarefaDTO dto = new TarefaDTO(null, "Estudar", "Revisar conteúdo", StatusTarefa.PENDENTE, "Sem café", null, null);
        Tarefa entidade = new Tarefa(1L, "Estudar", "Revisar conteúdo", StatusTarefa.PENDENTE, "Sem café", null, null);

        when(repository.save(any())).thenReturn(entidade);

        TarefaDTO resultado = service.criar(dto);

        assertNotNull(resultado.getId());
        assertEquals("Estudar", resultado.getNome());
    }

    @Test
    public void deveBuscarTarefaPorId() {
        Tarefa entidade = new Tarefa(1L, "Dormir", "Depois de formar", StatusTarefa.CONCLUIDA, "Com travesseiro", null, null);
        when(repository.findById(1L)).thenReturn(Optional.of(entidade));

        TarefaDTO resultado = service.buscarPorId(1L);

        assertEquals("Dormir", resultado.getNome());
        assertEquals(StatusTarefa.CONCLUIDA, resultado.getStatus()); // ← aqui estava o erro
    }
}


