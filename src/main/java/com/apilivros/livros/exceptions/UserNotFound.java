package com.apilivros.livros.exceptions;

public class UserNotFound extends RuntimeException{
    public UserNotFound() {
        super("Objeto não encontrado!");
    }
    public UserNotFound(String mensage) {
        super(mensage);
    }
}
