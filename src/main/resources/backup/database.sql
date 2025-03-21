create database biblioteca;
use biblioteca;
create table livros (
    idlivros varchar(10) primary key not null,
    nome varchar(45) not null,
    sinopse varchar(45) not null,
    autor varchar(45) not null,
    anolancamento int not null
);
create table users (
  idusers varchar(255) NOT NULL,
  email varchar(255) DEFAULT NULL,
  nome varchar(255) DEFAULT NULL,
  senha varchar(255) DEFAULT NULL,
  tipo_usuario enum('user','admin') DEFAULT 'user',
  PRIMARY KEY (`idusers`),
  UNIQUE KEY `unique_email` (`email`)
);