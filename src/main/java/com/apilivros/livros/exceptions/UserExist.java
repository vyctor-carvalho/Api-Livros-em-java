package com.apilivros.livros.exceptions;

public class UserExist extends RuntimeException {
    public UserExist() {
        super("Usuário já existente.");
    }
    public UserExist(String message) {
        super(message);
    }
}
