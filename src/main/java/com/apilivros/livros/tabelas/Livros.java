package com.apilivros.livros.tabelas;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livros {
    @Id
    @Column(name = "idlivros")
    private String idLivro;
    @Column(name = "nome")
    private String nome;
    @Column(name = "autor")
    private String autor;
    @Column(name = "sinopse")
    private String sinopse;
    @Column(name = "anolancamento")
    private int dataLacamento;

    public Livros() {

    }

    public Livros(String idLivro, String nome, String altor , String sinopse, int dataLacamento) {
        this.idLivro = idLivro;
        this.nome = nome;
        this.autor = altor;
        this.sinopse = sinopse;
        this.dataLacamento = dataLacamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(String idLivro) {
        this.idLivro = idLivro;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    public int getDataLacamento() {
        return dataLacamento;
    }

    public void setDataLacamento(int dataLacamento) {
        this.dataLacamento = dataLacamento;
    }
}
