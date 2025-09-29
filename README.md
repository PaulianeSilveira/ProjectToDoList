# 📋 ProjectToDoList

Projeto avaliativo desenvolvido para a disciplina **Laboratório de Desenvolvimento Multiplataforma — 1º Bimestre**.

Uma API REST construída com Java e Spring Boot para gerenciamento de tarefas. O sistema permite criar, listar, atualizar, buscar e excluir tarefas, com mensagens personalizadas e testes automatizados para garantir a qualidade do código.

---

## 🚀 Tecnologias utilizadas

- Java 17
- Spring Boot 3.5.6
- Spring Data JPA
- PostgreSQL
- Maven
- JUnit 5
- Mockito
- MockMvc

---

## ⚙️ Como rodar o projeto

### 1. Clonar o repositório

```bash
git clone https://github.com/PaulianeSilveira/ProjectToDoList.git

2. Configurar o banco de dados PostgreSQL

No arquivo src/main/resources/application.properties, configure:

spring.datasource.url=jdbc:postgresql://localhost:5432/todolist
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update

Certifique-se de que o banco todolist esteja criado no PostgreSQL.

3. Executar a aplicação

Via terminal:

mvn spring-boot:run

Ou via IDE (Eclipse, IntelliJ): execute a classe ProjetoToDoListApplication.java

📮 Endpoints da API

Método

Endpoint

Descrição

POST

/api/tarefas

Criar nova tarefa

GET

/api/tarefas

Listar todas as tarefas

GET

/api/tarefas/{id}

Buscar tarefa por ID

PUT

/api/tarefas/{id}

Atualizar tarefa existente

DELETE

/api/tarefas/{id}

Excluir tarefa

🗨️ Mensagens personalizadas

A API retorna mensagens claras e amigáveis, como:

✅ Tarefa criada com sucesso!

✏️ Tarefa atualizada com sucesso!

🗑️ Tarefa deletada com sucesso!

❌ Tarefa não encontrada.

🧪 Testes

Como executar os testes

mvn test

Testes incluídos

Testes unitários da camada de serviço (TarefaServiceImplTest)

Testes de integração dos endpoints REST (TarefaResourceIT)

Todos os testes foram desenvolvidos com JUnit 5, Mockito e MockMvc, garantindo cobertura e confiabilidade.
