package com.pauliane.todolist.api.resource;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pauliane.todolist.api.dto.TarefaDTO;
import com.pauliane.todolist.api.exception.RegraNegocioException;
import com.pauliane.todolist.service.TarefaService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/tarefas")
@RequiredArgsConstructor
public class TarefaResource {

    private final TarefaService service;

    @PostMapping
    public ResponseEntity<String> criar(@RequestBody TarefaDTO dto) {
        TarefaDTO nova = service.criar(dto);
        return ResponseEntity.ok("Tarefa criada com sucesso! ID: " + nova.getId());
    }

    @GetMapping
    public ResponseEntity<List<TarefaDTO>> listar() {
        List<TarefaDTO> tarefas = service.listar();
        return ResponseEntity.ok(tarefas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarPorId(@PathVariable Long id) {
        try {
            TarefaDTO tarefa = service.buscarPorId(id);
            return ResponseEntity.ok(tarefa);
        } catch (RegraNegocioException e) {
            return ResponseEntity.status(404).body("Tarefa com ID " + id + " não encontrada.");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizar(@PathVariable Long id, @RequestBody TarefaDTO dto) {
        TarefaDTO atualizada = service.atualizar(id, dto);
        return ResponseEntity.ok("Tarefa com ID " + id + " atualizada com sucesso!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.ok("Tarefa com ID " + id + " foi deletada com sucesso!");
    }
}




