create database biblioteca;
use biblioteca;
create table livros (
    idlivros varchar(10) primary key not null,
    nome varchar(45) not null,
    sinopse varchar(45) not null,
    autor varchar(45) not null,
    anolancamento int not null
);
