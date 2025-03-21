package com.apilivros.livros.controller;

import com.apilivros.livros.exceptions.UserExist;
import com.apilivros.livros.sevices.TokenSevice;
import com.apilivros.livros.repositoty.UsersRepository;
import com.apilivros.livros.tabelas.Contas;
import com.apilivros.livros.tabelas.authorities.AuthenticationData;
import com.apilivros.livros.tabelas.authorities.ResponseToken;
import com.apilivros.livros.tabelas.authorities.SiginData;
import com.apilivros.livros.tabelas.authorities.UserEnun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("alth")
public class AuthenticationUsersControler {
    @Autowired
    private AuthenticationManager authenticator;
    @Autowired
    private UsersRepository repository;
    @Autowired
    TokenSevice tokenSevice;

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody AuthenticationData data) {
        var tokenLogin = new UsernamePasswordAuthenticationToken(data.email(), data.senha());
        System.out.println(tokenLogin);
        var auth = this.authenticator.authenticate(tokenLogin);

        var token = tokenSevice.generate((Contas) auth.getPrincipal());

        return ResponseEntity.ok(new ResponseToken(token));
    }

    @PostMapping("/sigin")
    public Contas sigin(@RequestBody SiginData data) {
        if (this.repository.findByEmail(data.email()) != null) throw new UserExist();

        String senhaCriptografada = new BCryptPasswordEncoder().encode(data.senha());
        String id = UUID.randomUUID().toString();

        Contas newConta = new Contas(id, data.nome(), data.email(), senhaCriptografada);

        newConta.setRoles(UserEnun.USER);

        this.repository.save(newConta);

        return newConta;
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
