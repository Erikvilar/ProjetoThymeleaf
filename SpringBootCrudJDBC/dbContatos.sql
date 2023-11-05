create database dbContatos;
USE dbContatos;

CREATE TABLE tb_contatos(
    email VARCHAR(255) PRIMARY KEY,
    nome VARCHAR(255),
    telefone VARCHAR(11),
    cpf varchar(11)
);



ALTER TABLE tb_contatos
MODIFY email VARCHAR(255) NOT NULL;

INSERT INTO tb_contatos VALUES ('angoti@iftm.edu.br', 'Edson Angoti', '34988885566','71872690121');



select email,nome,telefone,cpf from tb_contatos;