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
- **Banco de Dados**: Conexão com o banco de dados para armazenamento persistente de dados (exemplo: MySQL, PostgreSQL).
- **JPA (Java Persistence API)**: Para a persistência de dados com o banco de dados.

## Endpoints

A API expõe os seguintes endpoints para realizar as operações CRUD:

- **POST /livros**: Criar um novo livro.
- **GET /livros/{id}**: Recuperar informações de um livro específico pelo ID.
- **PUT /livros/{id}**: Atualizar os dados de um livro pelo ID.
- **DELETE /livros/{id}**: Deletar um livro pelo ID.

## Como Executar o Projeto

### 1. Pré-requisitos

- **Java 21** ou superior instalado.
- **Maven** ou **Gradle** para gerenciar as dependências.
- Banco de dados configurado (MySQL, PostgreSQL, etc.) com as credenciais adequadas.

### 2. Clonando o Repositório

Clone o repositório para o seu ambiente local:

```bash
git clone https://github.com/vyctor-carvalho/Api-Livros-em-java.git
