package com.apilivros.livros.repositoty;

import com.apilivros.livros.tabelas.Contas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApiDeLivrosUsersRepository extends JpaRepository<Contas, String> {

}
