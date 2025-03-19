package com.apilivros.livros.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Getter
@Setter
public class ExcepiontModel {
    private HttpStatus status;
    private String mensage;
}
