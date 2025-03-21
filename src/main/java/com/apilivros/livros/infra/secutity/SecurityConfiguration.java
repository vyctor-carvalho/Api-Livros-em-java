package com.apilivros.livros.infra.secutity;

import com.apilivros.livros.tabelas.authorities.UserEnun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    SecuriyFilter filtro;

    @Bean
    public SecurityFilterChain filter(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable())
                .sessionManagement(sessao -> sessao.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(autorizado -> autorizado
                        .requestMatchers(HttpMethod.POST, "/livros").hasRole(UserEnun.ADMIN.toString())
                        .requestMatchers(HttpMethod.DELETE, "/livros").hasRole(UserEnun.ADMIN.toString())
                        .requestMatchers(HttpMethod.PUT, "/livros").hasRole(UserEnun.ADMIN.toString())
                        .requestMatchers(HttpMethod.POST, "/alth/sigin").permitAll()
                        .requestMatchers(HttpMethod.POST, "/alth/login").permitAll()
                        .anyRequest().authenticated()
                )
                .addFilterBefore(filtro, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticator (AuthenticationConfiguration authenticatorConfig) throws Exception {
        return authenticatorConfig.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder descripSenha() {
        return new BCryptPasswordEncoder();
    }
}
