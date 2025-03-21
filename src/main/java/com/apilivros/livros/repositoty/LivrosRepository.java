package com.apilivros.livros.repositoty;

import com.apilivros.livros.tabelas.Livros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivrosRepository extends JpaRepository <Livros, String> {
    List<Livros> findByNomeContaining(String nome);
    List<Livros> findAll();
}
