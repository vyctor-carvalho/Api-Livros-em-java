package com.apilivros.livros.controller;

import com.apilivros.livros.model.Livros;
import com.apilivros.livros.repositoty.ApiDeLivrosRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/livros")
public class ApiDeLivrosController {

    private ApiDeLivrosRepository repository;

    public ApiDeLivrosController(ApiDeLivrosRepository repository) {
        this.repository = repository;
    }

    //Colocando um array de objetos
    @PostMapping()
    public List<Livros> addLivros(@RequestBody List<Livros> livros) {

        for (Livros i : livros) {
            String id = UUID.randomUUID().toString();
            i.setIdLivro(id);
            repository.save(i);
            System.out.println("Livro " + i.getNome() + " cadastrado com sucesso.");
        }
        return livros;
    }

    @GetMapping("/{id}")
    public Optional<Livros> get (@PathVariable("id") String id) {
        Optional<Livros> livro = repository.findById(id);
        return livro;
    }

    @GetMapping()
    public List<Livros> getByNome (@RequestParam(value = "nome", required = false) String nome) {
        if (!StringUtils.hasText(nome)) {
            return repository.findAll();
        }
        return  repository.findByNomeContaining(nome);
    }

    @DeleteMapping("/{id}")
    public void delet (@PathVariable("id") String id) {
        repository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void alterar (@RequestBody Livros livro, @PathVariable("id") String id) {
        livro.setIdLivro(id);
        repository.save(livro);
    }
}
