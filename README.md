# ToDo List API

API RESTful para gerenciamento de tarefas (ToDo List) construída em Java com Spring Boot.

---

## 📋 Funcionalidades

- Criar, listar, atualizar e deletar tarefas
- Filtrar tarefas por status (`PENDING`, `COMPLETED`, `CANCELED`)
- Conversão entre Entities e DTOs feita manualmente
- Documentação interativa com Swagger UI
- Estrutura organizada e fácil de manter

---

## 🚀 Tecnologias utilizadas

- Java 17+
- Spring Boot 3.5.0
- Spring Web
- Spring Data JPA
- Gradle
- Banco de dados relacional (MySQL)
- Swagger (via Springdoc OpenAPI)

---

## 📌 Endpoints da API

| Método | Rota                         | Descrição                                                |
|--------|------------------------------|----------------------------------------------------------|
| POST   | `/tasks`                     | Criar uma nova tarefa                                    |
| GET    | `/tasks`                     | Listar todas as tarefas                                  |
| GET    | `/tasks/{id}`                | Buscar uma tarefa pelo ID                                |
| PUT    | `/tasks/{id}`                | Atualizar os dados de uma tarefa                         |
| DELETE | `/tasks/{id}`                | Deletar uma tarefa                                       |
| PUT    | `/tasks/{id}/status`         | Atualizar apenas o status da tarefa                      |
| GET    | `/tasks/status/{status}`     | Listar tarefas por status (`PENDING`, `COMPLETED`, `CANCELED`) |

---

## ⚙️ Como rodar localmente

1. Clone o repositório:

```bash
git clone https://github.com/Lucasdesouza-ctrl/to-do-list-API
cd seu-repositorio
```
2. Edite application.properties com suas configurações de banco de dados:

```
spring.datasource.url=jdbc:mysql://localhost:port/yourDatabase
spring.datasource.username=root
spring.datasource.password=yourPassword
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```
3. Rode a aplicação com o Gradle:

```bash
./gradlew bootRun
```
4. Acesse a documentação Swagger
   
```http://localhost:8080/swagger-ui.html```

