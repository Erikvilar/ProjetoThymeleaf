package br.edu.iftm.crud.SpringBootJDBC.domain;


import lombok.Data;


@Data
public class Contato {
   

    private String nome;
    private String email;
    private String telefone;
    private String cpf;


    

    public Contato() {
        
    }
    public Contato(String nome, String email, String telefone, String cpf ) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.cpf = cpf;
       
    }

    
    
}