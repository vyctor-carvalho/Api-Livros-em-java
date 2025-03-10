# API de Gestão de Livros

Este é o meu primeiro projeto de API em Java. A API foi desenvolvida utilizando **Spring Boot** e **Java 21** para realizar operações CRUD (Criar, Ler, Atualizar e Deletar) em livros, interagindo diretamente com o banco de dados.

## Funcionalidades

- **Criar**: Adicionar novos livros ao banco de dados.
- **Ler**: Recuperar informações sobre livros armazenados.
- **Atualizar**: Modificar dados de livros existentes no banco de dados.
- **Deletar**: Remover livros do banco de dados.

## Tecnologias Utilizadas

- **Java 21**: Linguagem utilizada para desenvolver a API.
- **Spring Boot**: Framework utilizado para construir e configurar a API.
<<<<<<< HEAD
- **Banco de Dados**: Conexão com o banco de dados para armazenamento persistente de dados (exemplo: MySQL, PostgreSQL).
=======
- **Banco de Dados**: Conexão com o banco de dados para armazenamento no MySQL.
>>>>>>> c485820 (Adicionando um findAll() e conectando ao banco de dados)
- **JPA (Java Persistence API)**: Para a persistência de dados com o banco de dados.

## Endpoints

A API expõe os seguintes endpoints para realizar as operações CRUD:

<<<<<<< HEAD
- **POST /livros**: Criar um novo livro.
- **GET /livros/{id}**: Recuperar informações de um livro específico pelo ID.
- **PUT /livros/{id}**: Atualizar os dados de um livro pelo ID.
- **DELETE /livros/{id}**: Deletar um livro pelo ID.
=======
- **POST /livros**: Cria um novo livro.
- **GET /livros**: Recupera todos os livros.
- **GET /livros?name=""**: Recupera todos os livros que tenham o parâmetro passado em alguma parte do nome.
- **GET /livros/{id}**: Recupera informações de um livro específico pelo ID.
- **PUT /livros/{id}**: Atualiza os dados de um livro pelo ID.
- **DELETE /livros/{id}**: Deleta um livro pelo ID.
>>>>>>> c485820 (Adicionando um findAll() e conectando ao banco de dados)

## Como Executar o Projeto

### 1. Pré-requisitos

- **Java 21** ou superior instalado.
<<<<<<< HEAD
- **Maven** ou **Gradle** para gerenciar as dependências.
- Banco de dados configurado (MySQL, PostgreSQL, etc.) com as credenciais adequadas.
=======
- **Maven** para gerenciar as dependências.
- Banco de dados configurado (usei MySQL) com as credenciais adequadas.
- o arquivo slq está em "src/main/resources/backup" com o json contendo os livros inseridos pela requisição http.
>>>>>>> c485820 (Adicionando um findAll() e conectando ao banco de dados)

### 2. Clonando o Repositório

Clone o repositório para o seu ambiente local:

```bash
<<<<<<< HEAD
git clone https://github.com/vyctor-carvalho/Api-Livros-em-java.git
=======
git clone https://github.com/vyctor-carvalho/Api-Livros-em-java
```
>>>>>>> c485820 (Adicionando um findAll() e conectando ao banco de dados)
