package com.apilivros.livros.controller;

import com.apilivros.livros.exceptions.UserNotFound;
import com.apilivros.livros.tabelas.Livros;
import com.apilivros.livros.repositoty.ApiDeLivrosRepository;
import org.springframework.http.HttpStatus;
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
    @CrossOrigin(origins = "http://localhost:5173")
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

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping("/{id}")
    public Optional<Livros> get (@PathVariable("id") String id) {

        Optional<Livros> livro = repository.findById(id);
        if (livro.isEmpty()) {
            throw new UserNotFound();
        }

        return livro;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @GetMapping()
    public List<Livros> getByNome (@RequestParam(value = "nome", required = false) String nome) {
        List<Livros> livros = repository.findByNomeContaining(nome);
        if (livros.isEmpty()) {
            throw new UserNotFound();
        }
        if (!StringUtils.hasText(nome)) {
            return repository.findAll();
        }

        return  livros;
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @DeleteMapping("/{id}")
    public void delet (@PathVariable("id") String id) {
        if (repository.findById(id).isEmpty()) {
            throw new UserNotFound();
        }
        repository.deleteById(id);
    }

    @CrossOrigin(origins = "http://localhost:5173")
    @PutMapping("/{id}")
    public void alterar (@RequestBody Livros livro, @PathVariable("id") String id) {
        if (repository.findById(id).isEmpty()) {
            throw new UserNotFound();
        }
        livro.setIdLivro(id);
        repository.save(livro);
    }
}
