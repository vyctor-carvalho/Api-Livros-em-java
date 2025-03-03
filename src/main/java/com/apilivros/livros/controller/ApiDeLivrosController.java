package com.apilivros.livros.controller;

import com.apilivros.livros.model.Livros;
import com.apilivros.livros.repositoty.ApiDeLivrosRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/livros")
public class ApiDeLivrosController {

    private ApiDeLivrosRepository repository;

    public ApiDeLivrosController(ApiDeLivrosRepository repository) {
        this.repository = repository;
    }

    /*@RequestMapping()
    public String home () {
        return "<h1>Pagina inicial</h1>";
    }*/

    @PostMapping("/")
    public Livros post (@RequestBody Livros livro) {
        String id = UUID.randomUUID().toString();
        livro.setIdLivro(id);
        repository.save(livro);
        System.out.println("Produto " + livro.getNome() + " cadastrado com sucesso.");
        return livro;
    }

    @GetMapping("/{id}")
    public Optional<Livros> get (@PathVariable("id") String id) {
        Optional<Livros> livro = repository.findById(id);
        return livro;
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
