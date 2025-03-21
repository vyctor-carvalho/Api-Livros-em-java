package com.apilivros.livros.repositoty;

import com.apilivros.livros.tabelas.Contas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsersRepository extends JpaRepository<Contas, String> {
    UserDetails findByEmail(String login);
}
