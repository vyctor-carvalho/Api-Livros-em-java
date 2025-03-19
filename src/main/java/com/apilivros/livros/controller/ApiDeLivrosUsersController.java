package com.apilivros.livros.controller;

import com.apilivros.livros.tabelas.Contas;
import com.apilivros.livros.repositoty.ApiDeLivrosUsersRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class ApiDeLivrosUsersController {
    private ApiDeLivrosUsersRepository repository;

    public ApiDeLivrosUsersController(ApiDeLivrosUsersRepository repository) {
        this.repository = repository;
    }

    @PostMapping()
    public List<Contas> postUsers(@RequestBody List<Contas> conta){
        //Na prática só se salva uma conta por vez, mas está salvando vários para fins educacionais
        for (Contas i : conta) {
            String id = UUID.randomUUID().toString();
            i.setIdUsers(id);
            repository.save(i);
            System.out.println(i.getNome());
        }
        return conta;
    }

    @GetMapping()
    public List<Contas> getTodos() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Contas> getConta(@PathVariable("id") String id) {
        return repository.findById(id);
    }

    @PutMapping("/{id}")
    public void updateConta(@PathVariable("id") String id, @RequestBody Contas conta) {
        conta.setIdUsers(id);
        repository.save(conta);
    }

    @DeleteMapping("{id}")
    public void deletarConta(@PathVariable("id") String id) {
        repository.deleteById(id);
    }

}
