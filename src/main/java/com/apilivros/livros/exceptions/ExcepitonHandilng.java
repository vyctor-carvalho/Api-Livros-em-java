package com.apilivros.livros.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExcepitonHandilng {

    @ExceptionHandler(HttpMessageNotReadableException.class)
    private ResponseEntity<ExcepiontModel> invalidJson(HttpMessageNotReadableException ex) {
        String mensage = ex.getMessage();
        if (mensage.equals("JSON parse error: Cannot deserialize value of type `java.util.ArrayList<com.apilivros.livros.tabelas.Livros>` from Object value (token `JsonToken.START_OBJECT`)")) {
            mensage = "O Json é um array e precida estar em '[]'";
        }
        ExcepiontModel responseException = new ExcepiontModel(HttpStatus.BAD_REQUEST, mensage);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseException);
    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ExcepiontModel> notFoundPage(NoHandlerFoundException ex) {
        String mensage = ex.getMessage();
        ExcepiontModel errorResponse = new ExcepiontModel(HttpStatus.NOT_FOUND, mensage);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExcepiontModel> NoIndexFound(Exception ex) {
        String mensage = "Erro interno: " + ex.getMessage();
        ExcepiontModel errorResponse = new ExcepiontModel(HttpStatus.INTERNAL_SERVER_ERROR, mensage);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<ExcepiontModel> userNotFound(UserNotFound ex) {
        ExcepiontModel errorResponse = new ExcepiontModel(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }
}
