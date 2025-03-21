package com.apilivros.livros.tabelas.authorities;

import lombok.Getter;

@Getter
public enum UserEnun {
    ADMIN("admin"),
    USER("user");

    private String role;

    UserEnun(String role) {
        this.role = role;
    }
}
