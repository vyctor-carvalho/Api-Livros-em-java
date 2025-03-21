package com.apilivros.livros.infra.secutity;

import com.apilivros.livros.repositoty.UsersRepository;
import com.apilivros.livros.sevices.TokenSevice;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import java.io.IOException;

@Component
public class SecuriyFilter extends OncePerRequestFilter {
    @Autowired
    UsersRepository repository;
    @Autowired
    TokenSevice sevice;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = recoverToken(request);
        System.out.println("O token -> " + token);
        if (token == null) filterChain.doFilter(request, response);
        var login = sevice.validarToken(token);
        if (token == null) {
            filterChain.doFilter(request, response);
            return; // PARA a execução aqui e evita erro
        }
        System.out.println("O login -> " + login);
        UserDetails user = repository.findByEmail(login);

        if (user != null) {
            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            System.out.println(authentication);
            SecurityContextHolder.getContext().setAuthentication(authentication);

        } else {
            System.out.println("Usuário não encontrado para o login!");
            throw new RuntimeException();
        }
        filterChain.doFilter(request, response);
    }

    public String recoverToken(HttpServletRequest request) {
        var auth = request.getHeader("Authorization");
        if (auth == null) return null;
        return auth.replace("Bearer ", "");
    }
}