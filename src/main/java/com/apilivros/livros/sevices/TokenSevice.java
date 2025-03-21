package com.apilivros.livros.sevices;

import com.apilivros.livros.tabelas.Contas;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.*;

@Service
public class TokenSevice {
    @Value("${api.security.token.secret}")
    private String segredo;
    public String generate(Contas conta) {
        try {
            Algorithm codigo = Algorithm.HMAC256(segredo);
            System.out.println("generate -> \n");
            return JWT.create()
                    .withIssuer("api-livros")
                    .withSubject(conta.getEmail())
                    .withExpiresAt(expirationTime())
                    .sign(codigo);
        } catch (JWTVerificationException ex) {
            System.out.println("Erro ao validar token: " + ex.getMessage());
            return null;
        }
    }

    public String validarToken(String token) {
        try {
            Algorithm codigo = Algorithm.HMAC256(segredo);
            System.out.println("validar -> \n ");
            return JWT.require(codigo)
                    .withIssuer("api-livros")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTDecodeException ex) {
            throw new RuntimeException("Token inválido ou expirado.");
        }
    }

    public Instant expirationTime() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
