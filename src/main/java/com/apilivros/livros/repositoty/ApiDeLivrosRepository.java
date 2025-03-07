package com.apilivros.livros.repositoty;

import com.apilivros.livros.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApiDeLivrosRepository extends JpaRepository <Livros, String> {
    Livros findByNome(String nome);
}
