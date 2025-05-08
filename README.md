# URL Shortener

Um encurtador de URLs simples desenvolvido em **Java (Spring Boot)** como parte de um processo seletivo.

## Funcionalidades

- ✅ Cadastrar uma nova URL e gerar uma URL curta
- 📄 Listar todas as URLs cadastradas
- ❌ Deletar uma URL
- 🔁 Redirecionar para o endereço original a partir da URL curta

## Tecnologias utilizadas

- Java 21 + Spring Boot
- PostgreSQL
- Docker + Docker Compose
- Maven

## Como rodar o projeto

### Pré-requisitos

- [Docker](https://www.docker.com/)
- [Docker Compose](https://docs.docker.com/compose/)
- (Opcional) [Java 21 e Maven](https://adoptium.net/) para rodar localmente sem container

### Subindo com Docker

```bash
docker compose up --build
```

A aplicação será executada em: `http://localhost:8080`

O banco de dados PostgreSQL estará disponível em: `localhost:5432`

### Variáveis de ambiente usadas

Configure no `application.properties`:

```properties
spring.datasource.url=${SPRING_DATASOURCE_URL}
spring.datasource.username=${SPRING_DATASOURCE_USERNAME}
spring.datasource.password=${SPRING_DATASOURCE_PASSWORD}
```

Exemplo de `.env` para o Docker Compose:

```env
SPRING_DATASOURCE_URL=jdbc:postgresql://db:5432/shortener
SPRING_DATASOURCE_USERNAME=postgres
SPRING_DATASOURCE_PASSWORD=postgres
```

## Endpoints principais

- `POST /url` – Cria uma URL encurtada  
  Exemplo de body JSON:
  ```json
  {
    "originalUrl": "https://exemplo.com"
  }
  ```

- `GET /url` – Lista todas as URLs encurtadas

- `DELETE /url/{id}` – Deleta uma URL cadastrada pelo ID

- `GET /url/{shortened}` – Redireciona para a URL original usando o código encurtado

## Observações

- Este projeto foi desenvolvido com foco em simplicidade e clareza de código para fins de entrevista.
- A base de dados é persistida em volume Docker.
- O código está estruturado para fácil expansão (validações, autenticação, etc.).

---

📫 Caso precise de mais informações, entre em contato ou abra uma issue no repositório.
