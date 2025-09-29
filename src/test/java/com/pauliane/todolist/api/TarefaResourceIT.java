package com.pauliane.todolist.api;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.containsString;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TarefaResourceIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void deveCriarTarefaViaPost() throws Exception {
        String json = """
        {
            "nome": "Testar API",
            "descricao": "Verificar POST",
            "status": "PENDENTE",
            "observacoes": "Teste de integração"
        }
        """;

        mockMvc.perform(post("/api/tarefas")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("Tarefa criada com sucesso")))
            .andDo(print());
    }

    @Test
    public void deveListarTodasAsTarefas() throws Exception {
        mockMvc.perform(get("/api/tarefas"))
            .andExpect(status().isOk())
            .andDo(print());
    }

    @Test
    public void deveBuscarTarefaPorId() throws Exception {
        mockMvc.perform(get("/api/tarefas/12"))
            .andExpect(status().isOk())
            .andDo(print());
    }

    @Test
    public void deveAtualizarTarefa() throws Exception {
        String jsonAtualizado = """
        {
            "nome": "Tarefa Atualizada",
            "descricao": "Descrição modificada",
            "status": "EM_ANDAMENTO",
            "observacoes": "Atualizada via PUT"
        }
        """;

        mockMvc.perform(put("/api/tarefas/15")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonAtualizado))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("atualizada com sucesso")))
            .andDo(print());
    }

    @Test
    public void deveDeletarTarefa() throws Exception {
        mockMvc.perform(delete("/api/tarefas/16"))
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("foi deletada com sucesso")))
            .andDo(print());
    }
}

