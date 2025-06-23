# Bloco de Notas API

Uma API simples de bloco de notas, desenvolvida em Java com Spring Boot e Maven, containerizada com Docker. Permite criar, ler, atualizar e deletar notas armazenadas em um banco SQLite.

---

## 📋 Funcionalidades

* **CRUD de notas:**

  * Criar nova nota
  * Listar todas as notas
  * Recuperar nota por ID
  * Atualizar nota existente
  * Excluir nota por ID

## 🚀 Tecnologias

* Java 17
* Spring Boot 3
* Spring Data JPA
* Banco SQLite
* Maven
* Docker (opcional)

---

## 📥 Pré-requisitos

* Java 17 instalado
* Maven instalado
* (Opcional) Docker e Docker Compose

---

## 💾 Instalação e Uso

### 1. Clonar o repositório

```bash
git clone https://github.com/SammyKunimatsu/bloco-de-notas-api.git
cd bloco-de-notas-api
```

### 2. Build com Maven

```bash
mvn clean package -DskipTests
```

### 3. Executar localmente (sem Docker)

```bash
java -jar target/bloco-de-notas-app.jar
```

A aplicação ficará disponível em `http://localhost:8080/`.

### 4. Executar com Docker

1. Buildar a imagem Docker:

```bash
docker build -t bloco-notas-api .
```

2. Rodar o container:

```bash
docker run -d -p 8080:8080 bloco-notas-api
```

A documentação da API estará acessível em `http://localhost:8080/docs`.

---

## 📦 Estrutura do Projeto

```plaintext
bloco-de-notas-api/
├── data/                        # Scripts ou dados de exemplo (SQLite)
├── src/
│   ├── main/
│   │   ├── java/com/sammy/api/
│   │   │   ├── controller/      # Controllers REST
│   │   │   ├── model/           # Entidades JPA
│   │   │   ├── repository/      # Repositórios Spring Data
│   │   │   └── service/         # Lógica de negócio
│   │   └── resources/           # application.properties
│   └── test/                    # Testes unitários
├── Dockerfile                   # Containerização
├── .gitignore
└── pom.xml                      # Configuração Maven
```

---

## 🔌 Endpoints da API

Base URL: `http://localhost:8080/api/notes`

| Método | Endpoint  | Descrição              | Corpo de Requisição (JSON)                                 |
| ------- | --------- | ------------------------ | ------------------------------------------------------------ |
| POST    | `/`     | Criar uma nova nota      | `{ "title": "Título", "content": "Conteúdo" }`           |
| GET     | `/`     | Listar todas as notas    | —                                                           |
| GET     | `/{id}` | Obter nota por ID        | —                                                           |
| PUT     | `/{id}` | Atualizar nota existente | `{ "title": "Novo título", "content": "Novo conteúdo" }` |
| DELETE  | `/{id}` | Excluir nota por ID      | —                                                           |

---

## 🤝 Contribuição

1. Fork este repositório
2. Crie uma branch feature: `git checkout -b feature/minha-feature`
3. Faça suas alterações e commit: `git commit -m 'Minha nova feature'`
4. Faça push para a branch: `git push origin feature/minha-feature`
5. Abra um Pull Request

---

## 📄 Licença

Este projeto está licenciado sob a MIT License. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.
